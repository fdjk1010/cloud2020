package com.demo.springcloud.alibaba.service;

import com.demo.springcloud.entity.CommonResult;
import com.demo.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lzy
 * @date 2021/4/28 10:48
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)//调用微服务的名称,fabllback降级兜底
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
