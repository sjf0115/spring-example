package com.spring.example.controller;

import com.spring.example.bean.Address;
import com.spring.example.bean.User;
import com.spring.example.domain.Response;
import com.spring.example.domain.ResponseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 功能：异常处理器示例
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/5 07:51
 */
@RestController
@RequestMapping(value = "/users/exception", produces = "application/json;charset=UTF-8")
public class ExceptionController {
    // 查询单个用户
    @GetMapping("/{name}")
    public Response<User> getByName(@PathVariable String name) {

        User user = new User();
        user.setAge(21);
        user.setUserName(name);
        Address address = new Address();
        address.setProv("山东");
        address.setCity("淄博");
        user.setAddress(address);

        Random random = new Random();
        int max = 3;
        int min = 1;
        int randomValue = random.nextInt(max - min + 1) + min;
        if (randomValue == 1) {
            // 随机抛出一个异常 验证异常处理器是否捕获
            int i = 1/0;
        }

        return Response.success(user, ResponseCode.GET_SUCCESS);
    }
}
