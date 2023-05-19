package com.mybatis.example.demo;

import com.google.common.collect.Lists;
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
 * 功能：基于 Mapper 代理开发 实现批量插入功能
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/16 下午11:40
 */
public class BatchInsertStudent {
    public static void main(String[] args) throws IOException {
        // 加载 Mybatis 的核心配置文件 mybatis-config.xml
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession 并开启自动事务提交
        SqlSession session = sqlSessionFactory.openSession(true);

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        // 插入多个学生
        Student stu1 = new Student();
        stu1.setStuId(10003);
        stu1.setStuName("哈兰德");
        stu1.setStatus(1);

        Student stu2 = new Student();
        stu2.setStuId(10004);
        stu2.setStuName("姆巴佩");
        stu2.setStatus(1);

        List<Student> students = Lists.newArrayList();
        students.add(stu1);
        students.add(stu2);

        mapper.addStudents(students);

        // 释放资源
        session.close();
    }
}
