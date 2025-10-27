package com.stock.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.stereotype.Service;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@Service
public class StoreTccActionImpl implements StoreTccAction {

    @Override
    public boolean prepareDeductStock(BusinessActionContext context, Long productId, Integer count) {
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
