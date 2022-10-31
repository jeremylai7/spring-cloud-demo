package com.stock.dao;

import com.stock.model.Stock;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
public interface StockDao{

    /**
     * 减库存
     * @param id
     * @param num
     * @param createTime
     */
    void reduceStock(@Param("id") Long id,@Param("num") BigDecimal num,@Param("createTime") Date createTime);


    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    Stock selectById(@Param("id")Long id);
}
