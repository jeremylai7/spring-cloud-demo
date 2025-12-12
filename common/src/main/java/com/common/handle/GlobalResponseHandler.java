package com.common.handle;

import com.alibaba.fastjson.JSON;
import com.common.annotation.EnableResponseHandler;
import com.common.wrapper.WrapMapper;
import com.common.wrapper.Wrapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author: laizc
 * @date: 2025/12/11 16:56
 * @desc:
 */
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // EnableResponseHandler 才封装
        if (methodParameter.getMethod().isAnnotationPresent(EnableResponseHandler.class)) {
            return true;
        }
        if (methodParameter.getDeclaringClass().isAnnotationPresent(EnableResponseHandler.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (object instanceof String) {
            // String 转换特殊处理
            serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return JSON.toJSONString(WrapMapper.ok(object));
        }
        if (object instanceof Wrapper) {
            return object;
        }
        // 封装响应体
        return WrapMapper.ok(object);
    }
}
