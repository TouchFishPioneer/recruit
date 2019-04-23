package cn.herculas.recruit.exception;

import cn.herculas.recruit.enumeration.ExceptionStatusEnum;

public class RecruitException extends RuntimeException {
    private Integer exceptionCode;

    public RecruitException(ExceptionStatusEnum exceptionStatusEnum) {
        super(exceptionStatusEnum.getStatusDescription());
        this.exceptionCode = exceptionStatusEnum.getResultStatusCode();
    }

    public RecruitException(Integer exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }
}
