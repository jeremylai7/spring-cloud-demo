package com.stock.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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
@TableName("t_stock")
public class Stock {
    @TableId(type = IdType.AUTO)
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
