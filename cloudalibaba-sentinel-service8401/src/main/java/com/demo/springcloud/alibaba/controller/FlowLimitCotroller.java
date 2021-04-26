package com.demo.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lzy
 * @date 2021/4/26 10:30
 */
@RestController
public class FlowLimitCotroller {
    @GetMapping("/testA")
    public String testA() {
        //暂停毫秒
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "=====testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "=====testB";
    }
}
