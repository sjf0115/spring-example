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

    @Value("${name}")
    private String userName;

    @RequestMapping("/helloName")
    public String hello() {
        return "Hello " + userName + ", welcome to SpringBoot!";
    }
}
