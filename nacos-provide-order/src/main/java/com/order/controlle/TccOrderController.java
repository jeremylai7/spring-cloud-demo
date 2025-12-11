package com.order.controlle;

import com.common.annotation.EnableResponseHandler;
import com.order.service.OrderTccAction;
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
@EnableResponseHandler
public class TccOrderController {

    @Autowired
    private OrderTccAction orderTccAction;

    @GetMapping("/order")
    public Long order() {
        Long orderId = orderTccAction.prepareCreateOrder(null);
        return orderId;
    }

}
