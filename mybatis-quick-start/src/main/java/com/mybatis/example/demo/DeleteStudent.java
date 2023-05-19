package com.mybatis.example.demo;

import com.mybatis.example.mapper.StudentMapper;
import com.mybatis.example.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能：基于 Mapper 代理开发 实现删除功能
 *          删除指定学生
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/16 下午11:40
 */
public class DeleteStudent {
    public static void main(String[] args) throws IOException {
        // 加载 Mybatis 的核心配置文件 mybatis-config.xml
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession
        SqlSession session = sqlSessionFactory.openSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        // 删除一个学生信息
        int id = 4;
        int num = mapper.deleteStudentById(id);
        System.out.println("成功删除 " + num + " 行数据");

        // 释放资源
        session.close();
    }
}
