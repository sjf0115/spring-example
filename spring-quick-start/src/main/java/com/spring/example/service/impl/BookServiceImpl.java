package com.spring.example.service.impl;

import com.spring.example.dao.BookDao;
import com.spring.example.dao.impl.BookDaoImpl;
import com.spring.example.service.BookService;

/**
 * 功能：BookService 实现类
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/7 08:36
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void save() {
        System.out.println("bookService save ....");
        bookDao.save();
    }
}
