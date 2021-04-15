package com.demo.springcloud.module.service.impl;

import cn.hutool.core.util.IdUtil;
import com.demo.springcloud.module.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author lzy
 * @date 2021/4/14 17:13
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问，肯定ok
     *
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_ok,id: " + id;
    }

    /**
     * @param id
     * @return
     * @HystrixCommand (fallbackMethod)paymentInfo_TimeOut如果这个方法出事了，让paymentInfo_TimeOutHandler方法给我兜底
     * (commandProperties)设置调用超时时间3秒钟，3秒以内走原逻辑,原方法出错也走兜底方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        //暂停秒钟
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "耗时" + timeNumber + "秒钟" + " 线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id;
//        int age=10/0;
//        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "兜底8001系统繁忙或运行报错，请稍后再试，线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler,id: " + id;
    }

    //======服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期 10秒钟
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸 60%
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0)
            throw new RuntimeException("******id 不能负数");
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id 不能负数，请稍后再试,id:"+id;
    }
}
