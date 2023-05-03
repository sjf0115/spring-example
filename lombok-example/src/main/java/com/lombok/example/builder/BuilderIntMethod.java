package com.lombok.example.builder;

import lombok.Builder;

/**
 * 功能：@Builder
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/3 下午10:51
 */
public class BuilderIntMethod {
    @Builder
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

    }
}
