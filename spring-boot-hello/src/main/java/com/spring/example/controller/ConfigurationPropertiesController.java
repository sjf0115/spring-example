package com.spring.example.controller;

import com.spring.example.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能：通过 ConfigurationProperties 注解读取配置文件
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/4/25 上午8:29
 */
@RestController
public class ConfigurationPropertiesController {
    @Autowired
    private Person person;

    @RequestMapping("/hello4")
    public String hello() {
        String userName = person.getName();
        String userId = person.getId();
        List<String> sports = person.getSports();
        return "Hello " + userName + "(" + userId + "), do you like playing " + sports + "?";
    }
}
