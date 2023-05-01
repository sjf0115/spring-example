package com.lombok.example.setter;


import lombok.Getter;
import lombok.Setter;

/**
 * 功能：@Getter 与 @Setter 类级别
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/1 下午10:10
 */
@Setter
@Getter
public class GetterSetterClassUser {
    private static String school = "北京大学";
    private Long id;
    private String name;
}
