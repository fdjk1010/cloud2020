package com.demo.springcloud.module.service;

import com.demo.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author lzy
 * @date 2021/4/11 16:51
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
