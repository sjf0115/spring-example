package com.spring.example.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 功能： JDBCTemplate 原始示例
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/20 07:47
 */
public class JDBCTemplateExample {
    public static void main(String[] args) {
        // 创建数据源 Spring 内置的数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 创建 JDBCTemplate
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);

        // 执行 SQL
        template.update("INSERT INTO tb_book (type, name, description) VALUES('计算机理论', '深入理解 MyBatis', '好书')");
    }
}
