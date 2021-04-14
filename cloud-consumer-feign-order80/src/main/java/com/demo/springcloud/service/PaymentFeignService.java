package com.demo.springcloud.service;

import com.demo.springcloud.entity.CommonResult;
import com.demo.springcloud.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lzy
 * @date 2021/4/14 14:50
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//对应的服务名
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")//对应的8001的controller
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
