package com.spring.example.app.di;

import com.spring.example.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：XML 自动装配 默认 no
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/15 15:13
 */
public class DIXmlAutowireByNameApp {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/applicationContext-autowire-byName.xml");

        // 引用类型
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);
    }
}
