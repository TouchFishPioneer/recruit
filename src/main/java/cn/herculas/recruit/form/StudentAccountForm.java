package cn.herculas.recruit.form;

import lombok.Data;

@Data
public class StudentAccountForm {
    private String email;
    private String password;
    private String nickname;
    private Integer status;
    private String uuid;
}
