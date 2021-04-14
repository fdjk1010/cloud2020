package com.demo.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzy
 * @date 2021/4/14 10:10
 */

/**
 * 自定义runle配置类，不能放在@componentScan所扫描的当前包下以及子包下
 * 否则我们自定义的这个配置类就会被所有ribbon客户端共享
 * (@SpringBootApplication启动类注解包含@componentScan)
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
