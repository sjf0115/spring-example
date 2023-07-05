package com.spring.example.controller;

import com.spring.example.domain.Response;
import com.spring.example.domain.ResponseCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能：异常处理器 注意 需要让 ComponentScan 扫描到
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/5 07:56
 */
@RestControllerAdvice
public class ExceptionAdvice<T> {
    @ExceptionHandler(Exception.class)
    public Response<T> doException(Exception ex) {
        System.out.println("捕捉到一个异常");
        return Response.error(ex.getMessage(), ResponseCode.ERROR);
    }
}
