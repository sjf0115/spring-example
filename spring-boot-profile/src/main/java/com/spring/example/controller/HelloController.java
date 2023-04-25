package com.spring.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：HelloController
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/4/25 下午10:43
 */
@RestController
public class HelloController {

    @Value("${env}")
    private String env;

    @Value("${name}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        return "current env is " + env;
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "hello " + name;
    }
}
