package com.spring.example.app;

import com.spring.example.dao.BookDao;
import com.spring.example.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：应用示例
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/7 08:40
 */
public class
QuickStartApp {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取资源
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        System.out.println(".....................");

        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
    }
}
