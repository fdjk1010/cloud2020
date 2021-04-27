package com.demo.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.springcloud.entity.CommonResult;

/**
 * @author lzy
 * @date 2021/4/27 11:24
 */
public class CustomerBlockHandler {
    public static CommonResult HandlerException(BlockException e){
        return new CommonResult(4444,"按客户自定义，global HandlerException---1");
    }
    public static CommonResult HandlerException2(BlockException e){
        return new CommonResult(4444,"按客户自定义，global HandlerException---2");
    }
}
