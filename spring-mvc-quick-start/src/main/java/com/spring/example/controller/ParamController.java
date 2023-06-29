package com.spring.example.controller;

import com.spring.example.bean.Address;
import com.spring.example.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 功能：参数传递演示
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/6/27 07:43
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    // 普通参数传递：请求参数名与形参相同
    @RequestMapping(value = "/commonParam", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String commonParam(String name, int age) {
        System.out.println(name);
        return "{'type': '普通参数传递：请求参数名与形参相同', 'name': '" + name + "', 'age': " + age + " }";
    }


    // 普通参数传递：请求参数名与形参不同
    @RequestMapping(value = "/commonParam2", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String commonParam2(@RequestParam("name") String userName, int age) {
        System.out.println(userName);
        return "{'type': '普通参数传递：请求参数名与形参不同', 'name': '" + userName + "', 'age': " + age + " }";
    }

    // POJO参数传递
    @RequestMapping(value = "/pojoParam", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String pojoParam(Address address) {
        System.out.println(address.getProv());
        return "{'type': 'POJO参数传递', 'prov': '" + address.getProv() + "', 'city': '" + address.getCity() + "' }";
    }

    // POJO参数传递
    @RequestMapping(value = "/pojoParam2", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String pojoParam2(User user) {
        System.out.println(user.getUserName());
        System.out.println(user.getAge());
        System.out.println(user.getAddress().getProv());
        System.out.println(user.getAddress().getCity());
        return "{'type': 'POJO参数传递：嵌套', 'name': '" + user.getUserName() + "', 'prov': " + user.getAddress().getProv() + " }";
    }

    // 数组参数传递
    @RequestMapping(value = "/arrayParam", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String arrayParam(String[] likes) {
        System.out.println(likes);
        return "{'type': '数组参数传递', 'likes': '" + Arrays.toString(likes) + "'}";
    }

    // List参数传递
    @RequestMapping(value = "/listParam", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes) {
        System.out.println(likes);
        return "{'type': 'List参数传递', 'likes': '" + likes + "'}";
    }

    // Json List参数传递
    @RequestMapping(value = "/jsonListParam", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String jsonListParam(@RequestBody List<String> likes) {
        System.out.println(likes);
        return "{'type': 'List参数传递', 'likes': '" + likes + "'}";
    }

    // 日期类型参数传递
    // 默认格式 yyyy/MM/dd
    // 通过 pattern 属性修改格式
    @RequestMapping(value = "/dateParam", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String dateParam(Date defaultDate,
                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date patternDate) {
        System.out.println(defaultDate);
        System.out.println(patternDate);
        return "{'type': '日期类型参数传递', 'defaultDate': '" + defaultDate + "'}";
    }
}
