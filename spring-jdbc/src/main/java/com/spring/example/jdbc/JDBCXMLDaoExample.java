package com.spring.example.jdbc;

import com.spring.example.dao.BookDao;
import com.spring.example.domain.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 功能： 在持久层 Dao 通过 Spring XML 注入 JDBCTemplate
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/20 07:47
 */
public class JDBCXMLDaoExample {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        // 获取 BookDao JDBCTemplate 通过 XML 注入
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        // 查询多个
        List<Book> books = bookDao.getList();
        for (Book book : books) {
            System.out.println("查询多个：" + book);
        }
    }
}
