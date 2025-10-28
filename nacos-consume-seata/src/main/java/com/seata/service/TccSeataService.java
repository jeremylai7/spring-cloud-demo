package com.seata.service;

import com.seata.client.OrderClient;
import com.seata.client.StockClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@Service
public class TccSeataService {

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private StockClient stockClient;


    @GlobalTransactional(name = "tcc-create-order", rollbackFor = Exception.class)
    public void placeOrder(Integer num) {
        orderClient.tccOrder();
        stockClient.tccStock(num);
    }
}
