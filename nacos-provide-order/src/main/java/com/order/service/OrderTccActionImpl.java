package com.order.service;

import com.mysql.cj.log.Log;
import com.order.dao.OrderDao;
import com.order.model.Order;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextUtil;
import io.seata.rm.tcc.interceptor.ActionContextUtil;
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
        // 此方式赋值无效
        //context.getActionContext().put("orderId", orderId);
        // 升级版本到 1.5.2 使用 BusinessActionContextUtil 来设置上下文参数
        // Seata 在 RM → TC → RM 传递BusinessActionContext时，JSON 序列化 / 反序列化会将 Long 转为 Inter 类型
        // 保险做法都改成 String
        //BusinessActionContextUtil.addContext("orderId", orderId);
        BusinessActionContextUtil.addContext("orderIdStr", String.valueOf(orderId));
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
        Object orderIdObj = context.getActionContext("orderIdStr");
        if (orderIdObj != null) {
            return Long.valueOf(String.valueOf(orderIdObj));
        }
        return null;
    }
}
