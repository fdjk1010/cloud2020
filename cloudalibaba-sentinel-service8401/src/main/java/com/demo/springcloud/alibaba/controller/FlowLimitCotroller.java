package com.demo.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzy
 * @date 2021/4/26 10:30
 */
@RestController
@Slf4j
public class FlowLimitCotroller {
    @GetMapping("/testA")
    public String testA() {
        //暂停毫秒
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        return "=====testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "..testB");
        return "=====testB";
    }

    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");
        log.info("testD 一场比例");
        int a = 10 / 0;
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")//value随便取，只要唯一;blockHandler兜底方法名
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,//po1
                             //1。value：请求中传入参数的名称，如果不设置后台接口的value值，则会默认为该变量名。
                             // 比如上图中第一个参数如果不设置value="p1",则前端传入的参数名必须为po1,否则在后台接口中po1将接收不到对应的数据
                             // 2。required：该参数是否为必传项。默认是true，表示请求中一定要传入对应的参数，否则会报404错误，
                             // 如果设置为false时，当请求中没有此参数，将会默认为null,而对于基本数据类型的变量，则必须有值，
                             // 这时会抛出空指针异常。如果允许空值，则接口中变量需要使用包装类来声明。
                             @RequestParam(value = "p2",required = false)String p2){
        return "----testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException e){//BlockException必须接收
        return "-----deal_testHotKey";//sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }

}
