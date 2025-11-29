package com.spring.example.service;

import com.spring.example.bean.User;
import com.spring.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private UserMapper userMapper;

    /**
     * 获取用户列表
     * @return
     */
    public List<User> getList() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    /**
     * 根据用户ID获取用户详细信息
     * @param id
     * @return
     */
    public Optional<User> getDetail(Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }
}
