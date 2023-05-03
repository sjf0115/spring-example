package com.lombok.example.builder;

import lombok.Builder;

import java.util.List;

/**
 * 功能：
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/3 下午11:00
 */
public class BuilderArrayMethod {
    @Builder
    public int len(List<Long> nums) {
        return nums.size();
    }

    public static void main(String[] args) {

    }
}
