package com.lombok.example.nonNull;

import lombok.NonNull;

/**
 * 功能：@NonNull
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/2 下午9:20
 */
public class NoNullUser {
    private Long id;
    private String name;

    public NoNullUser(@NonNull Long id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Long id = 1221L;
        String name = null;
        NoNullUser user = new NoNullUser(id, name);
    }
}
