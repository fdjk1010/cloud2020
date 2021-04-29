package com.demo.springcloud.alibaba.controller;

import com.demo.springcloud.alibaba.entity.CommonResult;
import com.demo.springcloud.alibaba.entity.Order;
import com.demo.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lzy
 * @date 2021/4/29 16:03
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
