package com.common.handle;

import com.common.enums.ErrorCodeEnum;
import com.common.exception.BusinessException;
import com.common.wrapper.WrapMapper;
import com.common.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: laizc
 * @date: 2025/12/10
 * @desc:
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        System.out.println(">>> GlobalExceptionHandler loaded");
    }

    /**
     * 业务异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Wrapper<Object> handleBusinessException(BusinessException e) {
        log.error("业务异常:======={}", e.getMessage());
        return WrapMapper.error(e.getCode(), e.getMessage());
    }

    /**
     * Exception  其他无法处理的异常，都放这里处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Wrapper<Object> handleException(Exception e) {
        log.error("异常信息:======={}", e.getMessage(), e);
        return WrapMapper.error(ErrorCodeEnum.EC500.getCode(), e.getMessage());
    }
}
