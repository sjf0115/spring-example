package com.spring.example.dao;

import com.spring.example.model.Book;
import com.spring.example.model.BookExample;

public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Book row);

    int insertSelective(Book row);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book row);

    int updateByPrimaryKey(Book row);
}