package com.spring.example.service.impl;

import com.spring.example.dao.BookDao;
import com.spring.example.domain.Book;
import com.spring.example.domain.ResponseCode;
import com.spring.example.exception.BusinessException;
import com.spring.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    public Book getById(Integer id) {
        if(id <= 0){
            throw new BusinessException(ResponseCode.ERROR.getCode(), "请不要使用你的技术挑战我的耐性!");
        }
        // 将可能出现的异常进行包装，转换成自定义异常
//        try{
//            int i = 1/0;
//        }catch (Exception e){
//            throw new SystemException(ResponseCode.ERROR.getCode(),"服务器访问超时，请重试!",e);
//        }
        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
