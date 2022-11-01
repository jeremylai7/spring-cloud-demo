package com.stock.controller;

import com.stock.dao.StockDao;
import com.stock.model.Stock;
//import io.seata.core.context.RootContext;
import io.seata.core.context.RootContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
@RestController
public class StockController {

    @Resource
    private StockDao stockDao;

    /**
     * 扣减库存
     * @return
     */
    @GetMapping("/stock")
    @Transactional(rollbackFor = Exception.class)
    public String stock(BigDecimal num) throws Exception {
        System.out.println("全局xid" + RootContext.getXID());
        Stock stock = stockDao.selectById(Long.valueOf(1));
        // 实际流程，库存不够才报错
        //if (num.compareTo(stock.getNum()) == -1) {
        // 方便模拟流程，输入 10 就报错
        if (num.compareTo(BigDecimal.TEN) == 0) {
            throw new Exception("报错，回滚");
        }
        // 减库存
        stockDao.reduceStock(1L,num,new Date());
        return "ok";
    }
}
