package com.yxh.core.enums;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 10:36
 */
public enum QunarHomeWorkExceptionEnum {
    NOT_SUPPORT_PIPE(1, "暂不支持管道命令"),
    JUST_SUPRORT_PIPE(2, "只能支持以管道命令形式运行");
    /**
     * 编码
     */
    Integer code;
    /**
     * 服务后缀
     */
    String message;

    QunarHomeWorkExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Gets the value of code.
     *
     * @return the value of code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Gets the value of message.
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

}
