package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lzy
 * @date 2021/5/11 17:46
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除自动配置
public class RedisSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisSpringbootApplication.class, args);
    }
}
