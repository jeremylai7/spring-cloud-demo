package com.common.exception;

import lombok.Data;

/**
 * @author: laizc
 * @date: 2025/12/10
 * @desc:
 */
@Data
public class BusinessException extends RuntimeException {

    private Integer code = 500;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

}
