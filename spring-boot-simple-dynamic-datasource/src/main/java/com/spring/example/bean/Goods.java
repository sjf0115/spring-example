package com.spring.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能：商品示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/22 22:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Long id;
    private String name;
}
