package com.spring.example.domain;

/**
 * 功能：表现层返回结果标识
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/4 22:41
 */
public enum ResponseCode {
    ERROR(-1, "error"),
    SUCCESS(0, "success"),

    SAVE_SUCCESS(1010, "保存成功"),
    UPDATE_SUCCESS(1020, "更新成功"),
    DELETE_SUCCESS(1030, "删除成功"),
    GET_SUCCESS(1040, "查询成功"),

    SAVE_ERROR(1011, "保存失败"),
    UPDATE_ERROR(1021, "更新失败"),
    DELETE_ERROR(1031, "删除失败"),
    GET_ERROR(1041, "查询失败")
    ;

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
