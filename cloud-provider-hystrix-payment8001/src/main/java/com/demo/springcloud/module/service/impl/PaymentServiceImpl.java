package com.demo.springcloud.module.service.impl;

import com.demo.springcloud.module.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    /**
     * @HystrixCommand
     * (fallbackMethod)paymentInfo_TimeOut如果这个方法出事了，让paymentInfo_TimeOutHandler方法给我兜底
     * (commandProperties)设置调用超时时间3秒钟，3秒以内走原逻辑,原方法出错也走兜底方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber=3;
        //暂停秒钟
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "耗时"+timeNumber+"秒钟"+" 线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id;
//        int age=10/0;
//        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id;
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "兜底8001系统繁忙或运行报错，请稍后再试，线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOutHandler,id: "+id;
    }
}
