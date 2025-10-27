package com.stock.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@LocalTCC
public interface StoreTccAction {

    @TwoPhaseBusinessAction(name = "stockTccAction", commitMethod = "commit", rollbackMethod = "cancel")
    boolean prepareDeductStock(BusinessActionContext context,
                               @BusinessActionContextParameter(paramName = "productId") Long productId,
                               @BusinessActionContextParameter(paramName = "count") Integer count);

    boolean commit(BusinessActionContext context);

    boolean cancel(BusinessActionContext context);
}
