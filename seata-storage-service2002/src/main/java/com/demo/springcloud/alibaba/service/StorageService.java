package com.demo.springcloud.alibaba.service;

/**
 * @author lzy
 * @date 2021/4/30 10:43
 */
public interface StorageService {
    //扣减库存
    void decrease(Long productId,Integer count);
}
