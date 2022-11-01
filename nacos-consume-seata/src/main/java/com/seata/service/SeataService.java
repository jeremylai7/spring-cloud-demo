package com.seata.service;


import com.seata.client.OrderClient;
import com.seata.client.StockClient;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @author: laizc
 * @date: created in 2022-10-13
 * @desc:
 */
@Service
public class SeataService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private StockClient stockClient;

    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(Integer num) throws Exception{
        System.out.println("全局xid" + RootContext.getXID());
        /*String result = restTemplate.getForObject("http://nacos-provide-order/order",String.class);
        try {
            String result2 = restTemplate.getForObject("http://nacos-provide-stock/stock?num="+num,String.class);
        } catch (Exception e) {
            throw new Exception();
        }*/

        // 创建订单，库存够，成功。库存不够，报错回滚订单。
        orderClient.order();
        stockClient.stock(num);

        System.out.println("result");
    }

}


