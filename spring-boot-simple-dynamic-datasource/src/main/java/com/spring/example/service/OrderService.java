package com.spring.example.service;

import com.spring.example.bean.Order;
import com.spring.example.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 功能：OrderService 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:42
 */
@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 获取订单列表
     * @return
     */
    public List<Order> getList() {
        List<Order> orders = orderMapper.selectAll();
        return orders;
    }

    /**
     * 根据订单ID获取订单详细信息
     * @param id
     * @return
     */
    public Optional<Order> getDetail(Long id) {
        Order order = orderMapper.selectById(id);
        if (order == null) {
            return Optional.empty();
        }
        return Optional.of(order);
    }
}
