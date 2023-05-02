package com.lombok.example.constructor;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * 功能：@AllArgsConstructor
 *      为类生成一个包含三个参数(school, id, name)的构造函数
 *      为 id 字段生成一个 NULL 检查
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午10:02
 */
@AllArgsConstructor
public class AllArgsConstructorUser {
    private static int age;
    private final String school;
    @NonNull
    private Long id;
    private String name;
}
