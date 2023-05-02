package com.lombok.example.toString;

import lombok.ToString;

/**
 * 功能：@ToString 排除某个字段
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午4:30
 */
@ToString
public class ToStringNewExcludeUser {
    private static String school = "北京大学";
    private Long id;
    private String name;
    @ToString.Exclude private int age;
}
