package com.demo.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzy
 * @date 2021/4/26 10:30
 */
@RestController
public class FlowLimitCotroller {
    @GetMapping("/testA")
    public String testA() {
        return "=====testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "=====testB";
    }
}
