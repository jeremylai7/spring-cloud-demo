package com.seata.service;


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

    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(Integer num) {
        String result = restTemplate.getForObject("http://nacos-provide-order/order",String.class);
        String result2 = restTemplate.getForObject("http://nacos-provide-stock/stock?num="+num,String.class);
        System.out.println("result");
    }

}


