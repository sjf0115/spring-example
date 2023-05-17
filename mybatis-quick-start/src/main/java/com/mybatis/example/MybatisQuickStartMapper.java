package com.mybatis.example;

import com.mybatis.example.mapper.UserMapper;
import com.mybatis.example.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 功能：入口 基于 Mapper 代理开发
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/16 下午11:40
 */
public class MybatisQuickStartMapper {
    public static void main(String[] args) throws IOException {
        // 加载 Mybatis 的核心配置文件 mybatis-config.xml
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        // Mapper 代理 指定 UserMapper 接口
        // 查询所有的用户
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println("全部用户: " + user);
        }

        // 根据指定的ID查询用户
        User user = mapper.selectById(1);
        System.out.println("目标用户: " + user);

        // 释放资源
        session.close();
    }
}
