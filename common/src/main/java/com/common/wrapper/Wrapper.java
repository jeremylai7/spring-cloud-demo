package com.common.wrapper;

import lombok.Data;

/**
 * @author: laizc
 * @date: 2025/12/10 11:57
 * @desc:
 */
@Data
public class Wrapper<T> {

    /**
     * 编号
     */
    private int code;

    /**
     * 信息
     */
    private String message;

    /**
     * 结果数据
     */
    private T result;

    /**
     * 成功码
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 成功信息
     */
    public static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * 错误码
     */
    public static final int ERROR_CODE = 500;

    /**
     * 错误信息
     */
    public static final String ERROR_MESSAGE = "内部异常";

    private Wrapper<T> code(int code) {
        this.setCode(code);
        return this;
    }

    private Wrapper<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public Wrapper<T> result(T result) {
        this.setResult(result);
        return this;
    }


    public boolean success() {
        return Wrapper.SUCCESS_CODE == this.code;
    }

    public boolean error() {
        return !success();
    }

    Wrapper() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    Wrapper(int code, String message) {
        this(code, message, null);
    }

    Wrapper(int code, String message, T result) {
        super();
        this.code(code).message(message).result(result);
    }
}
