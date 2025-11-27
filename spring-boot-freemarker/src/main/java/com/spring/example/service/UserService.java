package com.spring.example.service;

import com.spring.example.bean.User;
import com.spring.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 功能：UserService 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:42
 */
@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users = Arrays.asList(
                User.builder().id(1L).name("john_doe").age(12).build(),
                User.builder().id(2L).name("jane_smith").age(30).build(),
                User.builder().id(3L).name("bob_wilson").age(22).build()
        );
    }
    /**
     * 获取用户列表
     * @return
     */
    public List<User> getList() {
        // 模拟所有用户数据
        return users;
    }

    /**
     * 根据用户ID获取用户详细信息
     * @param id
     * @return
     */
    public Optional<User> getDetail(Long id) {
        // 模拟根据用户ID获取用户
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
