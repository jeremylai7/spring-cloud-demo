package com.seata.proxy;

import com.common.exception.BusinessException;
import com.common.wrapper.BaseResponse;
import com.seata.proxy.feign.OrderFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: laizc
 * @date: 2025/12/12
 * @desc:
 */
@Component
@Slf4j
public class OrderFeignProxy {

    @Autowired
    private OrderFeign orderFeign;

    public String order() {
        BaseResponse<String> baseResponse = orderFeign.order();
        if (baseResponse == null) {
            throw new BusinessException("创建订单失败，请稍后再试");
        }
        if (!baseResponse.success()) {
            throw new BusinessException(baseResponse.getMessage());
        }
        return baseResponse.getResult();
    }

    public String orderUpdate() {
        BaseResponse<String> baseResponse = orderFeign.orderUpdate();
        if (baseResponse == null) {
            throw new BusinessException("订单更新失败，请稍后再试");
        }
        if (!baseResponse.success()) {
            throw new BusinessException(baseResponse.getMessage());
        }
        return baseResponse.getResult();
    }

    public Long tccOrder() {
        BaseResponse<Long> baseResponse = orderFeign.tccOrder();
        if (baseResponse == null) {
            throw new BusinessException("TCC创建订单失败，请稍后再试");
        }
        if (!baseResponse.success()) {
            throw new BusinessException(baseResponse.getMessage());
        }
        return baseResponse.getResult();
    }

}
