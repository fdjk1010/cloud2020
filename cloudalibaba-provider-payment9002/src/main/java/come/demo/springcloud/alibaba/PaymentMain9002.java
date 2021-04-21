package come.demo.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lzy
 * @date 2021/4/21 15:50
 */
@SpringBootApplication
@EnableDiscoveryClient//能够让注册中心能够发现，扫描到改服务
//@EnableEurekaClient只适用于Eureka作为注册中心
public class PaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9002.class,args);
    }
}
