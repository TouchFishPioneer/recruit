package cn.herculas.recruit.enumeration;

import lombok.Getter;

@Getter
public enum StudentContactStatusEnum {
    NOT_CONTACTED(0, "have not been reached"),
    CONTACTING(1, "under negotiating"),
    CONTACTED_NEGATIVE(2, "have been reached and confirm not coming"),
    CONTACTED_POSITIVE(3, "have been reached and signed the contract");


    private Integer studentContactStatusCode;
    private String contactStatusDescription;

    StudentContactStatusEnum(Integer studentContactStatusCode, String contactStatusDescription) {
        this.studentContactStatusCode = studentContactStatusCode;
        this.contactStatusDescription = contactStatusDescription;
    }
}
