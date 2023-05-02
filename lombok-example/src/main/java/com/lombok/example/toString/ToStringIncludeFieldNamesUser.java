package com.lombok.example.toString;

import lombok.ToString;

/**
 * 功能：@ToString
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午4:30
 */
@ToString(includeFieldNames = false)
public class ToStringIncludeFieldNamesUser {
    private static String school = "北京大学";
    private Long id;
    private String name;
}
