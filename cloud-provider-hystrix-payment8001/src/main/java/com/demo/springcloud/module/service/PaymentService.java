package com.demo.springcloud.module.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lzy
 * @date 2021/4/14 17:13
 */
public interface PaymentService {
    public String paymentInfo_ok(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
