package com.demo.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzy
 * @date 2021/4/27 14:34
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//负载均衡，默认轮回
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
