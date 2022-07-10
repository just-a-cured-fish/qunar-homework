package com.yxh.core.exception;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 10:34
 */
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    protected String msg;
    protected int code = 500;

    public GlobalException() {
    }

    public GlobalException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public GlobalException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public GlobalException(Integer code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public GlobalException(Integer code, String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

