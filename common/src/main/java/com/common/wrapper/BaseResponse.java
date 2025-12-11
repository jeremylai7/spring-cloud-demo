package com.common.wrapper;

import lombok.Data;

/**
 * @author mavis
 */
@Data
public class BaseResponse<T> {

    public static final int SUCCESS_CODE = 200;

    private int code;

    /**
     * 信息
     */
    private String message;

    /**
     * 结果数据
     */
    private T result;

    public boolean success() {
        return this.code == SUCCESS_CODE;
    }

    public static <T> BaseResponse<T> ok(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(SUCCESS_CODE);
        response.setMessage("操作成功");
        response.setResult(data);
        return response;
    }
}
