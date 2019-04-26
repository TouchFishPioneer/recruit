package cn.herculas.recruit.enumeration;

import lombok.Getter;

@Getter
public enum StudentInfoSourceEnum {
    IMPORT(0, "imported from local education authority"),
    REGISTER(1, "data from student self-registration"),
    IMPORT_AND_REGISTER(2, "student data have been confirmed");

    private Integer studentInfoSourceCode;
    private String sourceDescription;

    StudentInfoSourceEnum(Integer studentInfoSourceCode, String sourceDescription) {
        this.studentInfoSourceCode = studentInfoSourceCode;
        this.sourceDescription = sourceDescription;
    }
}
