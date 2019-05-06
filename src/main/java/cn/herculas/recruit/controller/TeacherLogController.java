package cn.herculas.recruit.controller;

import cn.herculas.recruit.data.DO.TeacherAccount;
import cn.herculas.recruit.data.VO.ResultVO;
import cn.herculas.recruit.form.TeacherLoginForm;
import cn.herculas.recruit.service.JsonWebTokenService;
import cn.herculas.recruit.service.TeacherCaptchaService;
import cn.herculas.recruit.service.TeacherRegistrationService;
import cn.herculas.recruit.util.parser.TeacherAccountParser;
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

@RestController
@RequestMapping("/log/teacher")
public class TeacherLogController {

    private final TeacherCaptchaService teacherCaptchaService;
    private final TeacherRegistrationService teacherRegistrationService;
    private final JsonWebTokenService jsonWebTokenService;

    public TeacherLogController(TeacherCaptchaService teacherCaptchaService,
                                TeacherRegistrationService teacherRegistrationService,
                                JsonWebTokenService jsonWebTokenService) {
        this.teacherCaptchaService = teacherCaptchaService;
        this.teacherRegistrationService = teacherRegistrationService;
        this.jsonWebTokenService = jsonWebTokenService;
    }

    @GetMapping("/captcha/key")
    public ResultVO createCaptcha() {
        String captchaKey = teacherCaptchaService.createCaptcha();
        Map<String, String> result = new HashMap<>();
        result.put("captcha_key", captchaKey);
        return ResultVO.success(result);
    }

    @GetMapping("/captcha/image")
    public void getCaptchaImage(@RequestParam("key") String captchaKey,
                                HttpServletResponse response) throws IOException {
        if (captchaKey == null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return;
        }

        String captchaContent = teacherCaptchaService.findCaptchaContent(captchaKey);
        if (captchaContent == null) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }

        BufferedImage captchaImage = teacherCaptchaService.createCaptchaImage(captchaContent);
        ImageIO.write(captchaImage, "JPEG", response.getOutputStream());
    }

    @PostMapping("/in")
    public ResultVO login(@Valid TeacherLoginForm teacherLoginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResultVO.error(HttpStatus.BAD_REQUEST);

        // Confirm captcha

        String captchaKeyForm = teacherLoginForm.getCaptcha_key();
        String captchaContentForm = teacherLoginForm.getCaptcha_content();

        String captchaContentRedis = teacherCaptchaService.findCaptchaContent(captchaKeyForm);
        if (captchaContentRedis == null)
            return ResultVO.error(HttpStatus.FORBIDDEN);
        else if (!captchaContentRedis.equals(captchaContentForm))
            return ResultVO.error(HttpStatus.FORBIDDEN);

        // Confirm username and password

        String usernameForm = teacherLoginForm.getUsername();
        String passwordForm = teacherLoginForm.getPassword();

        if (!teacherRegistrationService.confirmTeacherAccount(usernameForm, passwordForm))
            return ResultVO.error(HttpStatus.FORBIDDEN);

        // Generate token

        String token = jsonWebTokenService.createJsonWebToken(usernameForm);
        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        return ResultVO.success(result);
    }

    @GetMapping("/info")
    public ResultVO getInfo(@CookieValue("token") String token) {
        String teacherUsername = jsonWebTokenService.parseJsonWebToken(token);
        if (teacherUsername == null)
            return ResultVO.error(HttpStatus.FORBIDDEN);

        TeacherAccount teacherAccount = teacherRegistrationService.findTeacherAccountByUsername(teacherUsername);
        if (teacherAccount == null)
            return ResultVO.error(HttpStatus.NOT_FOUND);

        return ResultVO.success(TeacherAccountParser.viewParser(teacherAccount));
    }

    @PostMapping("/out")
    public ResultVO logout() {
        return ResultVO.success();
    }
}
