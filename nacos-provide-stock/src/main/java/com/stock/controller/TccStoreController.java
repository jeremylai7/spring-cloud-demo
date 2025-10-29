package com.stock.controller;

import com.stock.service.StoreTccAction;
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
public class TccStoreController {

    @Autowired
    private StoreTccAction storeTccAction;

    @GetMapping("/stock")
    public String stock(BigDecimal num) throws Exception {
        storeTccAction.prepareDeductStock(null,num);
        return "ok";
    }

}
