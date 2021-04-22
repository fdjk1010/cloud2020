package com.demo.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzy
 * @date 2021/4/22 9:28
 */
@RestController
@Slf4j
public class OrderNacosController {
    @Value("${server-url.nacos-user-service}")
    private String serverURL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id")Long id){
        String result=restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
        return result;
    }
}
