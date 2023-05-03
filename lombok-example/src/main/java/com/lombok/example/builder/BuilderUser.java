package com.lombok.example.builder;

import lombok.Builder;
import lombok.NonNull;

/**
 * 功能：@Builder
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午11:47
 */
@Builder
public class BuilderUser {
    private static int age;
    private final String school;
    @NonNull
    private Long id;
    private String name;

    public static void main(String[] args) {
        BuilderUser user = BuilderUser.builder()
                .id(123L)
                .name("Lucy")
                .school("家里蹲大学")
                .build();
    }
}
