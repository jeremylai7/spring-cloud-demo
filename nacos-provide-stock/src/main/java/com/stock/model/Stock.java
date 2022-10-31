package com.stock.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: laizc
 * @date: created in 2022/9/24
 * @desc:
 **/
@Getter
@Setter
public class Stock {

    private Long id;

    /**
     * 仓库号
     */
    private String sn;

    /**
     * 剩余库存
     */
    private BigDecimal num;


    /**
     * 创建时间
     */
    private Date createTime;
}
