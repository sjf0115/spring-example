package com.spring.example.app.di;

import com.spring.example.domain.Book;
import com.spring.example.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：依赖注入-setter注入
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/11 07:55
 */
public class DISetterApp {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 引用类型
        Book book = (Book) ctx.getBean("book-setter");
        System.out.println(book);

        // 引用类型
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);
    }
}
