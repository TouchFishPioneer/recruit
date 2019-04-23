package cn.herculas.recruit.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class StudentDetailForm {
    private String name;
    private Boolean gender;
    private String tel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String identity_number;
    private String admission_number;
    private String region;
    private String school;
    private Integer mark;
    private Integer division;
    private Integer rank;
    private String remarks;
    private String intentional_major;
    private String unintentional_major;
    private Integer grade;
    private String uuid;
}
