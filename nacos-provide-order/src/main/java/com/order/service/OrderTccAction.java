package com.order.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author: laizc
 * @date: created in 2025/10/24
 * @desc:
 **/
@LocalTCC
public interface OrderTccAction {

    @TwoPhaseBusinessAction(name = "orderTccAction", commitMethod = "commit", rollbackMethod = "cancel")
    Long prepareCreateOrder(BusinessActionContext context);

    boolean commit(BusinessActionContext context);

    boolean cancel(BusinessActionContext context);

}
