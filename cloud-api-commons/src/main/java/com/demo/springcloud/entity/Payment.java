package com.demo.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lzy
 * @date 2021/4/11 16:55
 */
@Data//get,set等等
@AllArgsConstructor//全参构造器
@NoArgsConstructor//空参构造器
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
