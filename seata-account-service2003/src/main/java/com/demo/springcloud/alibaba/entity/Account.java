package com.demo.springcloud.alibaba.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lzy
 * @date 2021/4/30 15:44
 */
@Data
public class Account {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;

}
