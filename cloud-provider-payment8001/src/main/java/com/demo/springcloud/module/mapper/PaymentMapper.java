package com.demo.springcloud.module.mapper;

import com.demo.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lzy
 * @date 2021/4/11 16:50
 */
@Mapper
public interface PaymentMapper {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
