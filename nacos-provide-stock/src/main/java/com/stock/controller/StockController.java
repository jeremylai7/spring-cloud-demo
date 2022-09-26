package com.stock.controller;

import com.stock.dao.StockDao;
import com.stock.model.Stock;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

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
    public String stock(Integer num) throws Exception {
        Stock stock = new Stock();
        stock.setSn("仓库1");
        Stock selectStock = stockDao.selectOne(stock);
        selectStock.setNum(selectStock.getNum().subtract(BigDecimal.TEN));
        stockDao.updateByPrimaryKey(selectStock);
        if (num == 0) {
            throw new Exception("报错，回滚");
        }
        return "ok";
    }
}
