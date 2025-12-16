package com.seata.service;

import com.common.Test;
import com.seata.proxy.OrderFeignProxy;
import com.seata.proxy.StockFeignProxy;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@Service
@Slf4j
public class TccSeataService {

    @Autowired
    private OrderFeignProxy feignProxy;

    @Autowired
    private StockFeignProxy stockFeignProxy;


    @GlobalTransactional(name = "tcc-create-order", rollbackFor = Exception.class)
    public void placeOrder(BigDecimal num) {
        Long orderId = feignProxy.tccOrder();
        log.info("订单id：{}", orderId);
        Test test = stockFeignProxy.tccStock(num);
        log.info("返回 test：{}", test);
    }
}
