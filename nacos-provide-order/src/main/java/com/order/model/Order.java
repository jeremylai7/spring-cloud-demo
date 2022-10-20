package com.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;


import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
@Data
@Accessors(chain = true)
@TableName("t_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String sn;

    /**
     * 数量
     */
    private BigDecimal num;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private Date createTime;

}
