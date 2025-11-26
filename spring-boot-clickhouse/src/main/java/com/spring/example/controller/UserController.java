package com.spring.example.controller;

import com.spring.example.bean.User;
import com.spring.example.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 功能：UserController
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/4/24 下午11:26
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/detail")
    public User getUser(@RequestParam String id) {
        Optional<User> userOptional = userService.getDetail(id);
        return userOptional.orElse(null);
    }
}
