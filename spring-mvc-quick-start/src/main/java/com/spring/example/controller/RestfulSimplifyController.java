package com.spring.example.controller;

import com.spring.example.bean.User;
import org.springframework.web.bind.annotation.*;

/**
 * 功能：Restfull 简化示例
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/3 07:46
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
public class RestfulSimplifyController {
    // 增：增加用户
//    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @PostMapping
    public String save(@RequestBody User user) {
        System.out.println("save: " + user);
        return "{\"type\": \"增加用户\", \"action\": \"POST\"}";
    }

    // 删：删除用户
//    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        System.out.println("delete: " + id);
        return "{\"type\": \"删除用户\", \"action\": \"DELETE\"}";
    }

    // 改：修改用户
//    @RequestMapping(value = "/users",method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @PutMapping
    public String update(@RequestBody User user) {
        System.out.println("update: " + user);
        return "{\"type\": \"修改用户\", \"action\": \"PUT\"}";
    }

    // 查：查询指定用户
//    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        System.out.println("getById: " + id);
        return "{\"type\": \"查询指定用户\", \"action\": \"GET\"}";
    }

    // 查：查询所有用户
//    @RequestMapping(value = "/users",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @GetMapping
    public String getAll() {
        System.out.println("getAll...");
        return "{\"type\": \"查询所有用户\", \"action\": \"GET\"}";
    }
}
