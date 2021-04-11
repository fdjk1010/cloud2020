package com.demo.springcloud.module.service.impl;

import com.demo.springcloud.entity.Payment;
import com.demo.springcloud.module.mapper.PaymentMapper;
import com.demo.springcloud.module.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzy
 * @date 2021/4/11 16:52
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
