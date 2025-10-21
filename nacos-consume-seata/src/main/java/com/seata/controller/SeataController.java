package com.seata.controller;

import com.seata.config.SpringContextUtil;
import com.seata.service.SeataService;

import com.zaxxer.hikari.HikariDataSource;
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
    private SeataService seataService;

    @GetMapping("/seata")
    public String seata(Integer num) throws Exception {
        seataService.placeOrder(num);
        return "ok";
    }

    @GetMapping("/test")
    public String test() {
        HikariDataSource aa =(HikariDataSource) SpringContextUtil.getBean("dataSource");
        return "aa";
    }

    @GetMapping("/seataUpdate")
    public String seataUpate(Integer num) throws Exception {
        seataService.updatePlaceOrder(num);
        return "ok";
    }

}
