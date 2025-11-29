package com.spring.example.service;

import com.spring.example.bean.User;
import com.spring.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能：UserService 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:42
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    // 插入用户
    public int save(User user) {
        return userDao.save(user);
    }

    // 更新用户
    public int update(User user) {
        return userDao.update(user);
    }

    // 根据 ID 删除用户
    public int deleteById(Long id) {
        return userDao.deleteById(id);
    }

    // 获取用户列表
    public List<User> getList() {
        return userDao.selectAll();
    }

    // 根据 ID 查询用户
    public User getDetail(Long id) {
        return userDao.selectById(id);
    }
}
