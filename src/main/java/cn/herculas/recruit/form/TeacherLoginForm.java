package cn.herculas.recruit.form;

import lombok.Data;

@Data
public class TeacherLoginForm {
    private String username;
    private String password;
    private String captcha_key;
    private String captcha_content;
}
