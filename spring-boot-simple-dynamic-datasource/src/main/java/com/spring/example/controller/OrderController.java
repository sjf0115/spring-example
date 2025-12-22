package com.spring.example.controller;

import com.spring.example.bean.DynamicDataSource;
import com.spring.example.bean.Order;
import com.spring.example.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 功能：OrderController 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:45
 */
@Slf4j
@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/list")
    public List<Order> getList() {
        DynamicDataSource.name.set("order");
        List<Order> orders = orderService.getList();
        return orders;
    }

    @GetMapping(value = "/detail")
    public Order getDetail(@RequestParam Long id) {
        DynamicDataSource.name.set("order");
        Optional<Order> userOptional = orderService.getDetail(id);
        return userOptional.orElse(null);
    }
}
