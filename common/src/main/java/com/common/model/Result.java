package com.common.model;

import lombok.Data;

/**
 * @author: laizc
 * @date: 2025/12/10 11:47
 * @desc:
 */
@Data
public class Result {

    private String code;

    private String message;

    private Object data;
}
