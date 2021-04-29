package com.demo.springcloud.alibaba.service.impl;

import com.demo.springcloud.alibaba.entity.Order;
import com.demo.springcloud.alibaba.mapper.OrderMapper;
import com.demo.springcloud.alibaba.service.AccountService;
import com.demo.springcloud.alibaba.service.OrderService;
import com.demo.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzy
 * @date 2021/4/29 15:36
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("----->开始新建订单");
        //1、新建订单
        orderMapper.create(order);

        log.info("----->订单微服务开始调用库存，做扣减Count");
        //2、扣减库存
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        log.info("----->订单微服务开始调用账户，做扣减Money");
        //3、扣减账户
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减Money end");

        //4、修改订单的状态，从零到1，1代表已经完成
        log.info("----->修改订单状态开始");
        orderMapper.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
    }
}
