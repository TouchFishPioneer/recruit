package cn.herculas.recruit.form;

import lombok.Data;

@Data
public class TeacherAccountForm {
    private String username;
    private String password;
    private String nickname;
    private Integer role;
    private Integer status;
    private String region;
    private String avatar;
    private String uuid;
}
