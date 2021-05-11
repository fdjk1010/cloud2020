package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzy
 * @date 2021/5/11 17:46
 */
@RestController
@RequestMapping("/redisTest")
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public String testRedis(){
        //设置值到redis
        redisTemplate.opsForValue().set("name","lucy");
        //从redis获取值
        Object name = redisTemplate.opsForValue().get("name");
        return (String) name;

    }
}