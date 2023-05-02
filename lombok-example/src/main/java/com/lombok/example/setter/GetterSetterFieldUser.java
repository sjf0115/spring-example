package com.lombok.example.setter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 功能：@Getter 与 @Setter 字段级别
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/1 下午10:36
 */
public class GetterSetterFieldUser {
    @Setter @Getter private Long id;
    @Setter(AccessLevel.PROTECTED)
    @Getter(AccessLevel.PRIVATE)
    private String name;
}
