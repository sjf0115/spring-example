package com.spring.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：通过 Value 注解读取配置文件
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/4/24 下午11:46
 */
@RestController
public class ValueController {

    // 纯量
    @Value("${name}")
    private String userName;

    // 对象 map
    @Value("${person.id}")
    private String userId;

    // 数组 array
    @Value("${fruits[0]}")
    private String fruit;

    @RequestMapping("/hello2")
    public String hello() {
        return "Hello " + userName + "(" + userId + "), do you like eating " + fruit + "?";
    }
}
