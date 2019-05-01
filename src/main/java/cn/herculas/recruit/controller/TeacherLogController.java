package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.enumeration.ExceptionStatusEnum;
import cn.herculas.recruit.form.TeacherLoginForm;
import cn.herculas.recruit.service.TeacherRegistrationService;
import cn.herculas.recruit.util.generator.KeyGenerator;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/log/teacher")
public class TeacherLogController {

    @Value("${captcha.expires}")
    private Integer expires;
    @Value("${captcha.prefix}")
    private String captchaPrefix;

    private final Producer captchaProducer;
    private final StringRedisTemplate stringRedisTemplate;
    private final TeacherRegistrationService teacherRegistrationService;

    public TeacherLogController(Producer captchaProducer, StringRedisTemplate stringRedisTemplate, TeacherRegistrationService teacherRegistrationService) {
        this.captchaProducer = captchaProducer;
        this.stringRedisTemplate = stringRedisTemplate;
        this.teacherRegistrationService = teacherRegistrationService;
    }

    @GetMapping("/captcha/key")
    public ResultVO createCaptchaKeyAndCode() {
        String captchaKey = captchaPrefix + KeyGenerator.uuidGenerator().substring(0, 10);
        String captchaContent = captchaProducer.createText();

        stringRedisTemplate.opsForValue().set(captchaKey, captchaContent, expires, TimeUnit.SECONDS);
        Map<String, String> result = new HashMap<>();
        result.put("captcha_key", captchaKey);
        return ResultVO.success(result);
    }

    @GetMapping("/captcha/image")
    public void createCaptchaImage(@RequestParam("key") String captchaKey, HttpServletResponse response) throws IOException {
        if (captchaKey == null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return;
        }

        String captchaContent = stringRedisTemplate.opsForValue().get(captchaKey);
        if (captchaContent == null) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }

        BufferedImage captchaImage = captchaProducer.createImage(captchaContent);
        ImageIO.write(captchaImage, "JPEG", response.getOutputStream());
    }

    @PostMapping("/in")
    public ResultVO login(@Valid TeacherLoginForm teacherLoginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        // Confirm captcha

        String captchaKeyForm = teacherLoginForm.getCaptcha_key();
        String captchaContentForm = teacherLoginForm.getCaptcha_content();

        String captchaContentRedis = stringRedisTemplate.opsForValue().get(captchaKeyForm);
        if (captchaContentRedis == null)
            return ResultVO.error(HttpStatus.FORBIDDEN);
        else if (!captchaContentRedis.equals(captchaContentForm))
            return ResultVO.error(HttpStatus.FORBIDDEN);

        // Confirm username and password

        String usernameForm = teacherLoginForm.getUsername();
        String passwordForm = teacherLoginForm.getPassword();

        if (!teacherRegistrationService.confirmTeacherAccount(usernameForm, passwordForm))
            return ResultVO.error(HttpStatus.FORBIDDEN);

        // TODO: Generate token
        return ResultVO.success();
    }

    @GetMapping("/info")
    public ResultVO getInfo() {
        return ResultVO.success();
    }

    @PostMapping("/out")
    public ResultVO logout() {
        return ResultVO.success();
    }
}
