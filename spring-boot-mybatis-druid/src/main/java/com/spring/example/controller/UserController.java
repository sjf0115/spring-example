package com.spring.example.controller;

import com.spring.example.bean.User;
import com.spring.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 功能：UserController 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:45
 */
@Slf4j
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<User> getList() {
        List<User> users = userService.getList();
        return users;
    }

    @GetMapping(value = "/detail")
    public User getDetail(@RequestParam Long id) {
        Optional<User> userOptional = userService.getDetail(id);
        return userOptional.orElse(null);
    }
}
