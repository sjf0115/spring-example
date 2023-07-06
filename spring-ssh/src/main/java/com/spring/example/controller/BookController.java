package com.spring.example.controller;

import com.spring.example.domain.Book;
import com.spring.example.domain.Response;
import com.spring.example.domain.ResponseCode;
import com.spring.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books", produces = "application/json;charset=UTF-8")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Response save(@RequestBody Book book) {
        boolean isSuccess = bookService.save(book);
        return Response.of(isSuccess, isSuccess ? ResponseCode.SAVE_SUCCESS : ResponseCode.SAVE_ERROR);
    }

    @PutMapping
    public Response update(@RequestBody Book book) {
        boolean isSuccess = bookService.update(book);
        return Response.of(isSuccess, isSuccess ? ResponseCode.UPDATE_SUCCESS : ResponseCode.UPDATE_ERROR);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        boolean isSuccess = bookService.delete(id);
        return Response.of(isSuccess, isSuccess ? ResponseCode.DELETE_SUCCESS : ResponseCode.DELETE_ERROR);
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        ResponseCode code = book != null ? ResponseCode.GET_SUCCESS : ResponseCode.GET_ERROR;
        String msg = book != null ? "" : "数据查询失败，请重试！";
        return Response.of(book, code, msg);
    }

    @GetMapping
    public Response getAll() {
        List<Book> bookList = bookService.getAll();
        ResponseCode code = bookList != null ? ResponseCode.GET_SUCCESS : ResponseCode.GET_ERROR;
        String msg = bookList != null ? "" : "数据查询失败，请重试！";
        return Response.of(bookList, code, msg);
    }
}
