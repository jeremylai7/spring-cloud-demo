package com.stock.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stock.model.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
@Mapper
@Repository
public interface StockDao extends BaseMapper<Stock> {
}
