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
 * 功能：基于 Mapper 代理开发 实现查询用户功能
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/16 下午11:40
 */
public class SelectStudent {
    public static void main(String[] args) throws IOException {
        // 加载 Mybatis 的核心配置文件 mybatis-config.xml
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        // 查询所有的学生
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        for (Student stu : students) {
            System.out.println("全部学生: " + stu);
        }

        // 根据指定的ID查询学生
        Student student = mapper.selectById(10001);
        System.out.println("目标学生: " + student);

        // 释放资源
        session.close();
    }
}
