package com.lombok.example.constructor;

import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 功能：@NoArgsConstructor
 *      生成无参构造函数
 *      在 `@NoArgsConstructor` 注解中使用 `force` 参数强制初始化为 `null`，否则编译器会报错
 *      对于带有约束的字段，例如 `@NonNull` 字段，在构造函数中也不会生成 NULL 检查
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午9:48
 */
@NoArgsConstructor(force = true)
public class NoArgsConstructorUser {
    private final String school;
    @NonNull
    private Long id;
    private String name;
}
