package com.seata.proxy;

import com.common.Test;
import com.common.exception.BusinessException;
import com.common.wrapper.BaseResponse;
import com.seata.proxy.feign.StockFeign;
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
public class StockFeignProxy {

    @Autowired
    private StockFeign stockFeign;


    public String stock(Integer num) {
        BaseResponse<String> baseResponse = stockFeign.stock(num);
        if (baseResponse == null) {
            throw new BusinessException("扣减库存失败，请稍后再试");
        }
        if (!baseResponse.success()) {
            throw new BusinessException(baseResponse.getMessage());
        }
        return baseResponse.getResult();
    }

    public Test tccStock(java.math.BigDecimal num) {
        BaseResponse<Test> baseResponse = stockFeign.tccStock(num);
        if (baseResponse == null) {
            throw new BusinessException("TCC扣减库存失败，请稍后再试");
        }
        if (!baseResponse.success()) {
            throw new BusinessException(baseResponse.getMessage());
        }
        return baseResponse.getResult();
    }

}
