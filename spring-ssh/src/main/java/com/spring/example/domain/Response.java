package com.spring.example.domain;

import org.springframework.util.StringUtils;

/**
 * 功能：表现层统一返回结果
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/4 22:40
 */
public class Response<T> {
    private T data;
    private String msg;
    private int code;

    public Response() {
    }

    public Response(T data, String msg, int code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public static <T> Response<T> of(T data, ResponseCode code) {
        return of(data, code, code.getMsg());
    }

    public static <T> Response<T> of(T data, ResponseCode code, String msg) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setCode(code.getCode());
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> success(T data) {
        return success(data, ResponseCode.SUCCESS);
    }

    public static <T> Response<T> success(T data, ResponseCode code) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setCode(code.getCode());
        response.setMsg(code.getMsg());
        return response;
    }

    public static <T> Response<T> error(String msg) {
        return error(ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> Response<T> error(int code, String msg) {
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
