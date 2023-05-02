package com.lombok.example.toString;

import lombok.ToString;

/**
 * 功能：@ToString 只包含某些字段
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午4:30
 */
@ToString(of = {"id", "name"})
public class ToStringOldIncludeUser {
    private static String school = "北京大学";
    private Long id;
    private String name;
    private int age;
}
