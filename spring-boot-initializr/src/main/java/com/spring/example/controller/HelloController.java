package com.spring.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：Hello Controller
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/4/24 下午11:18
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot Initializr!";
    }
}
