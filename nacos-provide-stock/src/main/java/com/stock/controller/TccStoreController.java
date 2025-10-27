package com.stock.controller;

import com.stock.service.StoreTccAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/store")
    public String store() {
        storeTccAction.prepareDeductStock(null,1L,1);
        return "ok";
    }

}
