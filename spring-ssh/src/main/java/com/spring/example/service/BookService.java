package com.spring.example.service;

import com.spring.example.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能：Book 服务类
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/3 07:46
 */
@Transactional
public interface BookService {

    /**
     * 保存
     * @param book
     * @return
     */
    public boolean save(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * 删除：按照ID删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 查询：按id查询
     * @param id
     * @return
     */
    public Book getById(Integer id);

    /**
     * 查询：查询全部
     * @return
     */
    public List<Book> getAll();
}
