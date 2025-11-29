package com.spring.example.dao;

import com.spring.example.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 功能：UserDao 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/29 12:13
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 插入用户
    public int save(User user) {
        String sql = "INSERT INTO tb_user (id, name, age) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, user.getId(), user.getName(), user.getAge());
    }

    // 更新用户
    public int update(User user) {
        String sql = "UPDATE tb_user SET name = ?, age = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getId());
    }

    // 根据 ID 删除用户
    public int deleteById(Long id) {
        String sql = "DELETE FROM tb_user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    // 根据 ID 查询用户
    public User selectById(Long id) {
        String sql = "SELECT * FROM tb_user WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null; // 没有找到记录时返回 null
        }
    }

    // 查询所有用户
    public List<User> selectAll() {
        String sql = "SELECT * FROM tb_user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    // 自定义 RowMapper
    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }
}
