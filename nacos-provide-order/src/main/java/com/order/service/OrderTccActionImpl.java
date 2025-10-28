package com.order.service;

import com.mysql.cj.log.Log;
import com.order.dao.OrderDao;
import com.order.model.Order;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@Service
@Slf4j
public class OrderTccActionImpl implements OrderTccAction{

    @Resource
    private OrderDao orderDao;

    @Override
    public Long prepareCreateOrder(BusinessActionContext context) {
        // 创建订单
        Order order = new Order();
        order.setNum(BigDecimal.TEN);
        order.setPrice(BigDecimal.TEN);
        order.setSn(UUID.randomUUID().toString());
        order.setCreateTime(new Date());
        orderDao.insert(order);
        log.info("prepare 创建订单，orderId={}", order.getId());
        context.getActionContext().put("orderId", order.getId());
        return order.getId();
    }

    @Override
    public boolean commit(BusinessActionContext context) {
        Long orderId = (Long) context.getActionContext("orderId");
        log.info("commit 创建订单，orderId={}", orderId);
        return false;
    }

    @Override
    public boolean cancel(BusinessActionContext context) {
        Long orderId = (Long) context.getActionContext("orderId");
        log.info("cancel 创建订单，orderId={}", orderId);
        orderDao.deleteById(orderId);

        return false;
    }
}
