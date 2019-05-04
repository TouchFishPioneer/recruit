package cn.herculas.recruit.exception;

import cn.herculas.recruit.enumeration.ExceptionStatusEnum;

public class RecruitException extends RuntimeException {
    private Integer exceptionCode;
    public RecruitException(ExceptionStatusEnum exceptionStatusEnum) {
        super(exceptionStatusEnum.getDescription());
        this.exceptionCode = exceptionStatusEnum.getCode();
    }
}
