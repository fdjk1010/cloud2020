package com.demo.springcloud.lb;

/**
 * @author lzy
 * @date 2021/4/14 11:10
 */

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自写负载均衡算法
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
