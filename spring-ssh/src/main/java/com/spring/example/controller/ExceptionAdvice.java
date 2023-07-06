package com.spring.example.controller;

import com.spring.example.domain.Response;
import com.spring.example.domain.ResponseCode;
import com.spring.example.exception.BusinessException;
import com.spring.example.exception.SystemException;
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

    @ExceptionHandler(SystemException.class)
    public Response doSystemException(SystemException ex){
        //记录日志
        System.out.println("捕捉到一个系统异常");
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return Response.error(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Response doBusinessException(BusinessException ex){
        System.out.println("捕捉到一个业务异常");
        return Response.error(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Response doOtherException(Exception ex){
        //记录日志
        System.out.println("捕捉到一个未知异常");
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return Response.error(ResponseCode.ERROR.getCode(), "系统繁忙，请稍后再试！");
    }
}
