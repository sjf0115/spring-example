package com.spring.example.controller;

import com.spring.example.bean.User;
import com.spring.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return userService.getList();
    }

    @GetMapping(value = "/detail")
    public User getDetail(@RequestParam Long id) {
        return userService.getDetail(id);
    }

    @DeleteMapping(value = "/delete")
    public int delete(@RequestParam Long id) {
        return userService.deleteById(id);
    }

    @PostMapping(value = "/update")
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping(value = "/save")
    public int save(@RequestBody User user) {
        return userService.save(user);
    }
}
