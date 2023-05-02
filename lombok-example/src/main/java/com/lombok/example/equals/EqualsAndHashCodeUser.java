package com.lombok.example.equals;

import lombok.EqualsAndHashCode;

/**
 * 功能：@EqualsAndHashCode
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午11:04
 */
@EqualsAndHashCode
public class EqualsAndHashCodeUser {
    @EqualsAndHashCode.Exclude private int age;
    private Long id;
    private String name;
}
