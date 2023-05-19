package com.mybatis.example.demo;

import com.mybatis.example.mapper.StudentMapper;
import com.mybatis.example.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 功能：基于 Mapper 代理开发 实现插入功能
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/16 下午11:40
 */
public class InsertStudent {
    public static void main(String[] args) throws IOException {
        // 加载 Mybatis 的核心配置文件 mybatis-config.xml
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession 并开启自动事务提交
        SqlSession session = sqlSessionFactory.openSession(true);

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        // 插入一个学生
        Student stu = new Student();
        stu.setStuId(10002);
        stu.setStuName("C罗");
        stu.setStatus(1);
        mapper.addStudent(stu);

        // 如果没有开启自动事务提交需要在这手动提交事务
        // session.commit();

        // 释放资源
        session.close();
    }
}
