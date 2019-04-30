package cn.herculas.recruit.form;

import lombok.Data;

@Data
public class TeacherDetailForm {
    private String name;
    private String card_number;
    private Integer gender;
    private String tel;
    private String department;
    private String duty;
    private String graduated_school;
    private String remarks;
    private String uuid;
}
