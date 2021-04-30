package com.demo.springcloud.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lzy
 * @date 2021/4/30 10:22
 */
@Mapper
public interface StorageMapper {
    //扣减库存
    void decrease(@Param("productId")Long productId,@Param("count")Integer count);
}
