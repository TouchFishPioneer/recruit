package cn.herculas.recruit.enumeration;

import lombok.Getter;

@Getter
public enum StudentDivisionEnum {
    LIBERAL(0, "liberal"),
    SCIENCE(1, "science"),
    ARTS(2, "arts"),
    SPORTS(3, "sports and physical");

    private Integer studentDivisionCode;
    private String divisionDescription;

    StudentDivisionEnum(Integer studentDivisionCode, String divisionDescription) {
        this.studentDivisionCode = studentDivisionCode;
        this.divisionDescription = divisionDescription;
    }
}
