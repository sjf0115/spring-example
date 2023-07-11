package com.spring.example.service.impl;

import com.spring.example.dao.BookDao;
import com.spring.example.service.BookService;

/**
 * 功能：BookService 实现类
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/7 08:36
 */
public class BookServiceImpl implements BookService {

    // 删除业务层中使用 new 方式创建的属性
    // private BookDao bookDao = new BookDaoImpl();

    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("bookService save ....");
        bookDao.save();
    }

    // 通过 setter 方法实现依赖注入
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
