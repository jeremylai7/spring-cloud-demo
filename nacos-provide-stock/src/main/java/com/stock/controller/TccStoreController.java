package com.stock.controller;

import com.common.Test;
import com.common.annotation.EnableResponseHandler;
import com.common.wrapper.BaseResponse;
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
@EnableResponseHandler
public class TccStoreController {

    @Autowired
    private StoreTccAction storeTccAction;

    @GetMapping("/stock")
    public Test stock(BigDecimal num) throws Exception {
        storeTccAction.prepareDeductStock(null,num);
        Test test = new Test();
        test.setName("success");
        return test;
    }

}
