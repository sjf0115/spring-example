package com.spring.example.app;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 功能：DruidDataSource 原始示例
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/8/14 07:23
 */
public class DruidDataSourceExample {
    public static void main(String[] args) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }
}
