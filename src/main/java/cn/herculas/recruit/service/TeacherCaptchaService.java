package cn.herculas.recruit.service;

import java.awt.image.BufferedImage;

public interface TeacherCaptchaService {
    String createCaptcha();
    String findCaptchaContent(String captchaKey);
    BufferedImage createCaptchaImage(String captchaContent);
}
