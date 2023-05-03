package com.lombok.example.data;

import lombok.Data;
import lombok.NonNull;

/**
 * 功能：@Data
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午11:45
 */
@Data
public class DataUser {
    private static int age;
    private final String school;
    @NonNull
    private Long id;
    private String name;
}
