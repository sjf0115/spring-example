package com.lombok.example.builder;

import lombok.Builder;

/**
 * 功能：
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/3 下午10:51
 */
public class BuilderStringMethod {
    @Builder
    public String toLower(String val) {
        return val.toLowerCase();
    }
}
