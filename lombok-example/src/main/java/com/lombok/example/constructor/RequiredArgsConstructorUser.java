package com.lombok.example.constructor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 功能：@RequiredArgsConstructor
 *      为特殊处理字段 `school` 以及 `id` 字段生成构造函数
 *      额外为 `id` 字段生成显式的 NULL 检查
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午10:14
 */
@RequiredArgsConstructor
public class RequiredArgsConstructorUser {
    private final String school;
    @NonNull
    private Long id;
    private String name;
}
