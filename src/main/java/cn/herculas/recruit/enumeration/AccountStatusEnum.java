package cn.herculas.recruit.enumeration;

import lombok.Getter;

@Getter
public enum AccountStatusEnum {
    DISABLED(0, "This account is disabled."),
    VALID(1, "This account is valid.");

    private Integer accountStatusCode;
    private String accountStatusDescription;

    AccountStatusEnum(Integer accountStatusCode, String accountStatusDescription) {
        this.accountStatusCode = accountStatusCode;
        this.accountStatusDescription = accountStatusDescription;
    }
}
