package com.seata.controller;

import com.common.annotation.EnableResponseHandler;
import com.common.wrapper.WrapMapper;
import com.common.wrapper.Wrapper;
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
@EnableResponseHandler
@RestController
@RequestMapping("/tcc")
public class TccSeataController {

    @Autowired
    private TccSeataService tccSeataService;

    /**
     * Jmeter 模拟并发，库存超卖问题
     * 设置库存 50，下单每次扣减5，开启500个线程，Ramp-Up 1sec，循环1次
     *
     *
     */
    @GetMapping("/seata")
    public Wrapper seata(BigDecimal num) throws Exception {
        tccSeataService.placeOrder(num);
        return WrapMapper.ok();
    }

}
