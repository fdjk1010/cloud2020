package com.demo.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lzy
 * @date 2021/4/15 15:14
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "PaymentFallbackService,fallback--paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService,fallback--paymentInfo_TimeOut";
    }
}



