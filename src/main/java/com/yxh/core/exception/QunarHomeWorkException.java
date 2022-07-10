package com.yxh.core.exception;

import com.yxh.core.enums.QunarHomeWorkExceptionEnum;
/**
 * @author yxh
 * @description
 * @time 2022/7/6 10:32
 */
public class QunarHomeWorkException extends GlobalException{
    public QunarHomeWorkException() {
        super();
    }

    public QunarHomeWorkException(String msg) {
        super(msg);
    }

    public QunarHomeWorkException(String msg, Throwable e) {
        super(msg, e);
    }

    public QunarHomeWorkException(String msg, int code) {
        super(code, msg);
    }

    public QunarHomeWorkException(Integer code, String msg) {
        super(code, msg);
    }

    public QunarHomeWorkException(QunarHomeWorkExceptionEnum errorEnum) {
        super(errorEnum.getCode(), errorEnum.getMessage());
    }

    public QunarHomeWorkException(String msg, int code, Throwable e) {
        super(code, msg, e);
    }
}
