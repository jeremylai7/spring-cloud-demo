package com.seata.service;

import com.common.exception.BusinessException;
import com.common.wrapper.Wrapper;
import com.seata.client.OrderClient;
import com.seata.client.StockClient;
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
    private OrderClient orderClient;

    @Autowired
    private StockClient stockClient;


    @GlobalTransactional(name = "tcc-create-order", rollbackFor = Exception.class)
    public void placeOrder(BigDecimal num) {
        Long orderId = orderClient.tccOrder();
        log.info("订单id：{}", orderId);
        Wrapper<String> result = stockClient.tccStock(num);
        if (!result.success()) {
            throw new BusinessException(result.getMessage());
        }
        System.out.println(result);
    }
}
