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
 * 功能：基于 Mapper 代理开发 实现更新功能
 *          更新全部字段
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/16 下午11:40
 */
public class UpdateStudent {
    public static void main(String[] args) throws IOException {
        // 加载 Mybatis 的核心配置文件 mybatis-config.xml
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession
        SqlSession session = sqlSessionFactory.openSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        // 更新一个学生信息
        Student stu = new Student();
        stu.setId(3);
        //stu.setStuId(10002);
        stu.setStuName("C罗-3");
        //stu.setStatus(1);
        int num = mapper.updateStudent(stu);
        System.out.println("成功修改 " + num + " 行数据");

        // 释放资源
        session.close();
    }
}
