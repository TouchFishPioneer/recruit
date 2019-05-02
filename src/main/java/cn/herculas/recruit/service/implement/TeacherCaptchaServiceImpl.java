package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.service.TeacherCaptchaService;
import cn.herculas.recruit.util.generator.KeyGenerator;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

@Service
public class TeacherCaptchaServiceImpl implements TeacherCaptchaService {

    @Value("${captcha.expires}")
    private Integer expires;
    @Value("${captcha.prefix}")
    private String captchaPrefix;

    private final Producer captchaProducer;
    private final StringRedisTemplate stringRedisTemplate;

    public TeacherCaptchaServiceImpl(Producer captchaProducer, StringRedisTemplate stringRedisTemplate) {
        this.captchaProducer = captchaProducer;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public String createCaptcha() {
        String captchaKey = captchaPrefix + KeyGenerator.uuidGenerator().substring(0, 10);
        String captchaContent = captchaProducer.createText();

        stringRedisTemplate.opsForValue().set(captchaKey, captchaContent, expires, TimeUnit.SECONDS);
        return captchaKey;
    }

    @Override
    public String findCaptchaContent(String captchaKey) {
        return stringRedisTemplate.opsForValue().get(captchaKey);
    }

    @Override
    public BufferedImage createCaptchaImage(String captchaContent) {
        return captchaProducer.createImage(captchaContent);
    }
}
