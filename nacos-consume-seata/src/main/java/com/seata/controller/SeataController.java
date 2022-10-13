package com.seata.controller;

import com.seata.service.SeataService;
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
    private SeataService seataService;

    @GetMapping("/seata")
    public String seata(Integer num) {
        seataService.placeOrder(num);
        return "ok";
    }

}
