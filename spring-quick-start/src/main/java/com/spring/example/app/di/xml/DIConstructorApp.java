package com.spring.example.app.di.xml;

import com.spring.example.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：依赖注入-构造器注入
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/11 07:55
 */
public class DIConstructorApp {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取资源
//        Book book = (Book) ctx.getBean("book");
//        System.out.println(book);
//
//        // name 属性注入
//        Book2 book2 = (Book2) ctx.getBean("book-name");
//        System.out.println(book2);
//
//        // type 属性注入
//        Book2 book21 = (Book2) ctx.getBean("book-type");
//        System.out.println(book21);
//
//        // type 属性注入 与预期不对 通过下文的 index 解决
//        Book3 book3 = (Book3) ctx.getBean("book-3-type");
//        System.out.println(book3);
//
//        // index 属性注入
//        Book3 book31 = (Book3) ctx.getBean("book-index");
//        System.out.println(book31);

        // 引用类型
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);
    }
}
