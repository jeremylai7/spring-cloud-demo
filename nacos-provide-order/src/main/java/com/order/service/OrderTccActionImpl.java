package com.order.service;

import com.mysql.cj.log.Log;
import com.order.dao.OrderDao;
import com.order.model.Order;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public Long prepareCreateOrder(BusinessActionContext context) {
        // 创建订单
        Order order = new Order();
        order.setNum(BigDecimal.TEN);
        order.setPrice(BigDecimal.TEN);
        order.setSn(UUID.randomUUID().toString());
        order.setCreateTime(new Date());
        orderDao.insert(order);
        Long orderId = order.getId();
        log.info("prepare 创建订单，orderId={}", orderId);
        context.getActionContext().put("orderId", orderId);
        return orderId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean commit(BusinessActionContext context) {
        Long orderId = getOrderId(context);
        log.info("commit 创建订单，orderId={}", orderId);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(BusinessActionContext context) {
        Long orderId = getOrderId(context);
        log.info("cancel 创建订单，orderId={}", orderId);
        orderDao.deleteById(orderId);
        return true;
    }

    private Long getOrderId(BusinessActionContext context) {
        return (Long) context.getActionContext("orderId");
    }
}
