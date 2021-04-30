package com.demo.springcloud.alibaba.service.impl;

import com.demo.springcloud.alibaba.mapper.StorageMapper;
import com.demo.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzy
 * @date 2021/4/30 10:47
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("-------------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("-------------->storage-service中扣减库存结束");
    }
}
