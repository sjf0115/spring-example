package com.spring.example.controller;

import com.spring.example.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：响应示例
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/1 23:23
 */
@Controller
public class ResponseController {
    // 响应页面
    @RequestMapping("/pageResponse")
    public String pageResponse() {
        System.out.println("跳转页面");
        return "index.jsp";
    }

    // 响应文本数据
    @RequestMapping("/textResponse")
    @ResponseBody
    public String textResponse() {
        System.out.println("返回纯文本数据");
        return "{\"data\": \"Hello SpringMVC!\"}";
    }

    // 响应 Pojo 对象
    @RequestMapping("/pojoResponse")
    @ResponseBody
    public User pojoResponse() {
        System.out.println("返回对象数据");
        User user = new User();
        user.setUserName("xiaosi");
        user.setAge(21);
        return user;
    }

    // 响应 Pojo 对象集合
    @RequestMapping("/pojoListResponse")
    @ResponseBody
    public List<User> pojoListResponse() {
        System.out.println("返回对象集合数据");

        User user = new User();
        user.setUserName("xiaosi");
        user.setAge(21);

        User user2 = new User();
        user2.setUserName("xiaosi2");
        user2.setAge(22);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        return users;
    }
}
