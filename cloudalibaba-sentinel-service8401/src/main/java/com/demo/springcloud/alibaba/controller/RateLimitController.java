package com.demo.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.demo.springcloud.entity.CommonResult;
import com.demo.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzy
 * @date 2021/4/27 10:19
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"seria1001"));
    }
    public CommonResult handleException(BlockException e){
        //e.getClass().getCanonicalName()哪个类在处理
        return new CommonResult(444,e.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }


    //CustomerBlockHandler
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,//指定兜底类
            blockHandler = "HandlerException2")//指定兜底类下面的具体某个方法
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按url限流测试0K",new Payment(2020L,"serial003"));
    }

}
