package com.demo.springcloud.module.service.impl;

import com.demo.springcloud.module.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lzy
 * @date 2021/4/14 17:13
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问，肯定ok
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_ok,id: "+id;
    }

    public String paymentInfo_TimeOut(Integer id){
        int timeNumber=3;
        //暂停3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "耗时"+timeNumber+"秒钟"+" 线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id;
    }
}
