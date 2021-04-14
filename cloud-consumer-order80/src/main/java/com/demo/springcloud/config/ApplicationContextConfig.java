package com.demo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzy
 * @date 2021/4/11 17:20
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced//ribbon负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
