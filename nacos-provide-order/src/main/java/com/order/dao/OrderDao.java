package com.order.dao;

import com.order.model.Order;
import org.apache.ibatis.annotations.Param;


/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
public interface OrderDao{

    void insert(Order order);

    void update(Order order);

    Order selectById(@Param("id") Long id);
}
