package com.seata.controller;

import com.seata.service.TccSeataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@RestController
@RequestMapping("/tcc")
public class TccSeataController {

    @Autowired
    private TccSeataService tccSeataService;

    @GetMapping("/seata")
    public String seata(BigDecimal num) throws Exception {
        tccSeataService.placeOrder(num);
        return "ok";
    }

}
