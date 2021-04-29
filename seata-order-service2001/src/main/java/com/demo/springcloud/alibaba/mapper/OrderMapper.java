package com.demo.springcloud.alibaba.mapper;

import com.demo.springcloud.alibaba.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lzy
 * @date 2021/4/29 15:00
 */
@Mapper
public interface OrderMapper {
    //1.新建订单
    void create(Order order);

    //2.修改订单状态，从零改为1
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
