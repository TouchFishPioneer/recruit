package cn.herculas.recruit.enumeration;

import lombok.Getter;

@Getter
public enum StudentGradeEnum {
    GRADE_TEN(1, "sophomore"),
    GRADE_ELEVEN(2, "junior"),
    GRADE_TWELVE(3, "senior");

    private Integer studentGradeCode;
    private String gradeDescription;

    StudentGradeEnum(Integer studentGradeCode, String gradeDescription) {
        this.studentGradeCode = studentGradeCode;
        this.gradeDescription = gradeDescription;
    }
}
