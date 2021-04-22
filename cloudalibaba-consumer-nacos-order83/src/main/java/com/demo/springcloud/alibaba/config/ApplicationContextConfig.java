package com.demo.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzy
 * @date 2021/4/22 9:26
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//结合Ribbon做负载均衡必须要该注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
