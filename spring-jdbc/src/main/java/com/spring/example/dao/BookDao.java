package com.spring.example.dao;

import com.spring.example.domain.Book;

import java.util.List;

public interface BookDao {
    List<Book> getList();
    Book getDetail(int id);
    void save(Book book);
}
