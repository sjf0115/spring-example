package com.spring.example.controller;

import com.spring.example.bean.User;
import com.spring.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
//@RestController  // 这会直接返回字符串，而不是渲染模板
@Controller // 这会渲染模板
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public String getList(Model model) {
        List<User> users = userService.getList();
        model.addAttribute("users", users);
        model.addAttribute("size", users.size());
        // 返回视图名称
        // FreeMarker 会根据配置解析为 templates/users/list.ftl
        return "users/list";
    }
}
