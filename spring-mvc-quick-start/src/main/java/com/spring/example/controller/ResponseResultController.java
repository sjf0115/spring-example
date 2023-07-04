package com.spring.example.controller;

import com.spring.example.bean.Address;
import com.spring.example.bean.User;
import com.spring.example.domain.Response;
import com.spring.example.domain.ResponseCode;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：统一返回查询结果
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/4 22:40
 */
@RestController
@RequestMapping(value = "/users/response", produces = "application/json;charset=UTF-8")
public class ResponseResultController {
    // 查询单个用户
    @GetMapping("/{name}")
    public Response<User> getByName(@PathVariable String name) {
        System.out.println("getByName: " + name);

        User user = new User();
        user.setAge(21);
        user.setUserName(name);
        Address address = new Address();
        address.setProv("山东");
        address.setCity("淄博");
        user.setAddress(address);

        return Response.success(user, ResponseCode.GET_SUCCESS);
    }

    // 查询所有用户
    @GetMapping
    public Response<List<User>> getAll() {
        System.out.println("getAll...");
        User user = new User();
        user.setAge(21);
        user.setUserName("Lucy");
        Address address = new Address();
        address.setProv("山东");
        address.setCity("淄博");
        user.setAddress(address);

        User user2 = new User();
        user2.setAge(23);
        user2.setUserName("Lily");
        Address address2 = new Address();
        address2.setProv("山东");
        address2.setCity("淄博");
        user2.setAddress(address2);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        return Response.success(users, ResponseCode.GET_SUCCESS);
    }
}
