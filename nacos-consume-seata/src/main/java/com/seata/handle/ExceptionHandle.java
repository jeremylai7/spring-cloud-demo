package com.seata.handle;

import com.alibaba.fastjson.JSONObject;
import feign.FeignException;
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
        if (e instanceof FeignException) {
            FeignException feignException = (FeignException) e;
            JSONObject json = new JSONObject();
            json.put("code",feignException.status());
            json.put("message",feignException.getMessage());
            return json;

        } else {
            JSONObject json = new JSONObject();
            json.put("code",e.getCause());
            json.put("message",e.getMessage());
            return json;
        }




    }
}
