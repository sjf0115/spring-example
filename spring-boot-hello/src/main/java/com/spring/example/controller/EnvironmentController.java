package com.spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：通过 Environment 方式读取配置文件
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/4/25 上午8:23
 */
@RestController
public class EnvironmentController {
    @Autowired
    private Environment env;

    @RequestMapping("/hello3")
    public String hello() {
        String userName = env.getProperty("name");
        String userId = env.getProperty("person.id");
        String fruit = env.getProperty("fruits[1]");
        return "Hello " + userName + "(" + userId + "), do you like eating " + fruit + "?";
    }
}
