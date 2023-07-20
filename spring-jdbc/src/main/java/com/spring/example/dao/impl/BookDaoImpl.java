package com.spring.example.dao.impl;

import com.spring.example.dao.BookDao;
import com.spring.example.domain.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * 功能：BookDao 实现类
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/20 08:18
 */
public class BookDaoImpl implements BookDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Book> getList() {
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
        return template.query("SELECT * FROM tb_book", rowMapper);
    }

    @Override
    public Book getDetail(int id) {
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
        return template.queryForObject("SELECT * FROM tb_book where id = ?", rowMapper, id);
    }

    @Override
    public void save(Book book) {
        template.update("INSERT INTO tb_book (type, name, description) VALUES(?, ?, ?)", book.getType(), book.getName(), book.getDescription());
    }
}
