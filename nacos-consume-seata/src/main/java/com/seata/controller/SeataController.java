package com.seata.controller;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
@RestController
public class SeataController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/seata")
    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional
    public String seata(Integer num) {
        String result = restTemplate.getForObject("http://nacos-order/order",String.class);
        String result2 = restTemplate.getForObject("http://nacos-stock/stock?num="+num,String.class);
        System.out.println(result);
        return "ok";
    }

}
