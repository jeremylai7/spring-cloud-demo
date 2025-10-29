package com.stock.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

import java.math.BigDecimal;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@LocalTCC
public interface StoreTccAction {

    @TwoPhaseBusinessAction(name = "stockTccAction", commitMethod = "commit", rollbackMethod = "cancel")
    boolean prepareDeductStock(BusinessActionContext context, BigDecimal num) throws Exception;

    boolean commit(BusinessActionContext context);

    boolean cancel(BusinessActionContext context);
}
