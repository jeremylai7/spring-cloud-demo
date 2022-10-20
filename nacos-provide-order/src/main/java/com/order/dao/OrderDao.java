package com.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
@Mapper
@Repository
public interface OrderDao extends BaseMapper<Order> {
}
