package com.order.controlle;

import com.order.dao.OrderDao;
import com.order.model.Order;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
@RestController
public class OrderController {

    @Resource
    private OrderDao orderDao;

    /**
     * 下单
     * @return
     */
    @GetMapping("/order")
    public String order() {
        System.out.println("全局xid" + RootContext.getXID());
        Order order = new Order();
        order.setNum(BigDecimal.TEN);
        order.setPrice(BigDecimal.TEN);
        order.setSn(UUID.randomUUID().toString());
        order.setCreateTime(new Date());
        orderDao.insert(order);
        return "ok";
    }

    @GetMapping("/orderUpdate")
    public String orderUpdate() {
        System.out.println("全局xid" + RootContext.getXID());
        Order order = orderDao.selectById(32L);
        order.setNum(order.getNum().add(BigDecimal.ONE));
        order.setPrice(BigDecimal.TEN.subtract(BigDecimal.ONE));
        order.setSn(order.getSn());
        order.setCreateTime(order.getCreateTime());
        orderDao.update(order);
        return "ok";
    }

}
