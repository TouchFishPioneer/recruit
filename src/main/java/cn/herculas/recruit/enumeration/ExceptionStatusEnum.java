package cn.herculas.recruit.enumeration;

import lombok.Getter;

@Getter
public enum  ExceptionStatusEnum {
    STUDENT_NOT_EXIST(0, "This student does not exist in database."),
    STUDENT_ALREADY_EXIST(1, "This student has already been in database."),

    INPUT_PARAMS_ERROR(10, "The input params from frontend have error.")
    ;

    private Integer resultStatusCode;
    private String statusDescription;

    ExceptionStatusEnum(Integer resultStatusCode, String statusDescription) {
        this.resultStatusCode = resultStatusCode;
        this.statusDescription = statusDescription;
    }
}
