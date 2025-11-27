package com.spring.example.controller;

import com.spring.example.bean.User;
import com.spring.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
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
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public String getList(Model model) {
        List<User> users = userService.getList();
        model.addAttribute("users", users);
        model.addAttribute("total", users.size());
        return "users/list";
    }

    @GetMapping(value = "/detail")
    public String getDetail(@RequestParam Long id, Model model) {
        Optional<User> userOptional = userService.getDetail(id);
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "users/detail";
        } else {
            model.addAttribute("error", "用户不存在");
            return "error/404";
        }
    }
}
