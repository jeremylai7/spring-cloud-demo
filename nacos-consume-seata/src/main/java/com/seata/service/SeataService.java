package com.seata.service;


import com.seata.proxy.OrderFeignProxy;
import com.seata.proxy.StockFeignProxy;
import com.seata.proxy.feign.StockFeign;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: laizc
 * @date: created in 2022-10-13
 * @desc:
 */
@Service
@Slf4j
public class SeataService {

    @Autowired
    private OrderFeignProxy orderFeignProxy;

    @Autowired
    private StockFeignProxy stockFeignProxy;

    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(Integer num){
        log.info("全局xid: {}", RootContext.getXID());
        // 创建订单，库存够，成功。库存不够，报错回滚订单。
        String result = orderFeignProxy.order();
        String stockResult = stockFeignProxy.stock(num);
        log.info("下单结果：{}，扣减库存结果：{}", result, stockResult);
    }

    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void updatePlaceOrder(Integer num) {
        System.out.println("全局xid" + RootContext.getXID());
        // 更新订单，回滚测试
        orderFeignProxy.orderUpdate();
        stockFeignProxy.stock(num);
    }
}


