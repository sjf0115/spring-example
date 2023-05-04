package com.lombok.example.value;

import lombok.NonNull;
import lombok.Value;

/**
 * 功能：@Value
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/3 下午11:51
 */
@Value
public class ValueUser {
    private static int age;
    private final String school;
    @NonNull
    private Long id;
    private String name;
}
