package com.demo.springcloud.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lzy
 * @date 2021/4/29 14:56
 */
@Data//set get
@AllArgsConstructor//全参构造器
@NoArgsConstructor//无参构造器
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    /**
     * 一般情况下，对于那些不需要准确计算精度的数字，我们可以直接使用Float和Double处理，
     * 但是Double.valueOf(String) 和Float.valueOf(String)会丢失精度。所以开发中，
     * 如果我们需要精确计算的结果，则必须使用BigDecimal类来操作。
     */
    private BigDecimal money;
    private Integer status;//'订单状态：0：创建中; 1：已完结'
}
