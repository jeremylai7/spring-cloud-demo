package com.stock.service;

import com.common.exception.BusinessException;
import com.stock.dao.StockDao;
import com.stock.model.Stock;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: laizc
 * @date: created in 2025/10/27
 * @desc:
 **/
@Service
public class StoreTccActionImpl implements StoreTccAction {

    @Resource
    private StockDao stockDao;

    @Override
    public boolean prepareDeductStock(BusinessActionContext context,BigDecimal num) throws Exception {
        num = num == null ? BigDecimal.ONE : num;
        System.out.println("全局xid" + RootContext.getXID());
        Stock stock = stockDao.selectById(Long.valueOf(1));
        BigDecimal subtractNum =  stock.getNum().subtract(num);
        if (subtractNum.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("库存不足 报错，回滚");
        }
        // 减库存
        stockDao.reduceStock(1L,num,new Date());
        BusinessActionContextUtil.addContext("stockIdStr", "1");
        BusinessActionContextUtil.addContext("numStr", num.toString());
        // 实际流程，库存不够才报错
        // 方便测试，输入 10 就报错
        if (num.compareTo(BigDecimal.TEN) == 0) {
            throw new BusinessException("报错，回滚");
        }
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext context) {
        return true;
    }

    @Override
    public boolean cancel(BusinessActionContext context) {
        Long stockId =  getStockId(context);
        BigDecimal num =  getNum(context);
        if (stockId != null) {
            // 回滚库存
            stockDao.increaseStock(stockId,num,new Date());
        }
        return true;
    }

    private Long getStockId(BusinessActionContext context) {
        Object orderIdObj = context.getActionContext("stockIdStr");
        if (orderIdObj != null) {
            return Long.valueOf(String.valueOf(orderIdObj));
        }
        return null;
    }

    private BigDecimal getNum(BusinessActionContext context) {
        Object orderIdObj = context.getActionContext("numStr");
        if (orderIdObj != null) {
            return new BigDecimal(String.valueOf(orderIdObj));
        }
        return null;
    }
}
