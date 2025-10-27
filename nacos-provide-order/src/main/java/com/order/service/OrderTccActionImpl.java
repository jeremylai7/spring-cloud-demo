package com.order.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.stereotype.Service;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@Service
public class OrderTccActionImpl implements OrderTccAction{
    @Override
    public boolean prepareCreateOrder(BusinessActionContext context, Long orderId) {
        return false;
    }

    @Override
    public boolean commit(BusinessActionContext context) {
        return false;
    }

    @Override
    public boolean cancel(BusinessActionContext context) {
        return false;
    }
}
