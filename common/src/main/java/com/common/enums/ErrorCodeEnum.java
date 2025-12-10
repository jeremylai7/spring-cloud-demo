package com.common.enums;

/**
 * @author: laizc
 * @date: 2025/12/10 14:07
 * @desc:
 */
public enum ErrorCodeEnum {

    EC500(500, "内部异常"),

    EC400(400, "参数异常")

    ;

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ErrorCodeEnum getEnumByCode(int code) {
        ErrorCodeEnum errorCodeEnum = null;
        for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
            if (ele.getCode() == code) {
                errorCodeEnum = ele;
                break;
            }
        }
        return errorCodeEnum;
    }
}
