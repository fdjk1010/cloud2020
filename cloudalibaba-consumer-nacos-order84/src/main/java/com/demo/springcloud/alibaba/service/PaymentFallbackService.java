package com.demo.springcloud.alibaba.service;

import com.demo.springcloud.entity.CommonResult;
import com.demo.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lzy
 * @date 2021/4/28 10:55
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444,"服务降级返回，--------PaymentFallbackService",new Payment(id,"error"));
    }
}
