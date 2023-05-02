package com.lombok.example.toString;

import lombok.ToString;

/**
 * 功能：
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午5:21
 */
@ToString
public class ToStringIncludeUser {
    private static String school = "北京大学";
    @ToString.Include(name = "user_id", rank = 1) private Long id;
    @ToString.Include(name = "user_name", rank = 2) private String name;
}
