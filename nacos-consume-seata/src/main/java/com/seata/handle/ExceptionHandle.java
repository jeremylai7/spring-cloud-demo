package com.seata.handle;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: laizc
 * @date: created in 2022-11-01
 * @desc: 全局异常处理
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JSONObject handle(Exception e) {
        JSONObject json = new JSONObject();
        json.put("code",e.getCause());
        json.put("message",e.getMessage());
        return json;
    }
}
