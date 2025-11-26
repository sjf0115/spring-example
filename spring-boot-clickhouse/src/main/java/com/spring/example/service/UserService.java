package com.spring.example.service;

import com.spring.example.bean.User;
import com.spring.example.config.ClickHouseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 功能：UserService 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 15:14
 */
@Service
public class UserService {
    @Resource
    private ClickHouseConfig config;

    /**
     * 根据用户ID获取用户详细信息
     * @param id
     * @return
     */
    public Optional<User> getDetail(String id) {
        List<Map<String, String>> result = config.exeSql("SELECT id, name, age FROM user WHERE id = '" + id + "'");
        if (result == null || result.isEmpty()) {
            return Optional.empty();
        }
        Map<String, String> map = result.get(0);
        User user = new User();
        user.setId(id);
        user.setName(map.get("name"));
        user.setAge(Integer.parseInt(map.get("age")));
        return Optional.of(user);
    }
}
