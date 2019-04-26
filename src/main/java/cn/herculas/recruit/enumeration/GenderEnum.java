package cn.herculas.recruit.enumeration;

import lombok.Getter;

@Getter
public enum GenderEnum {
    FEMALE(0, "female"),
    MALE(1, "male");

    private Integer genderCode;
    private String genderDescription;

    GenderEnum(Integer genderCode, String genderDescription) {
        this.genderCode = genderCode;
        this.genderDescription = genderDescription;
    }
}
