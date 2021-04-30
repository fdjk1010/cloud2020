package com.demo.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzy
 * @date 2021/4/29 16:05
 */
@Configuration
@MapperScan({"com.demo.springcloud.alibaba.mapper"})//告诉mybatis所有的mapper接口位置
public class MyBatisConfig {
}
