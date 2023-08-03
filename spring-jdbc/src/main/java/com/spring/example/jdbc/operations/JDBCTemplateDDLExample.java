package com.spring.example.jdbc.operations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 功能： JDBCTemplate 通过 Spring XML 注入 --- DDL 操作
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/20 07:47
 */
public class JDBCTemplateDDLExample {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
        // 获取 JDBCTemplate 数据源是通过 XML 注入
        JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        // DDL - 创建表
        template.execute("CREATE TABLE `tb_book_2` (\n" +
                "    `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "    `type` varchar(20) DEFAULT NULL,\n" +
                "    `name` varchar(50) DEFAULT NULL,\n" +
                "    `description` varchar(255) DEFAULT NULL,\n" +
                "    PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        // DDL - 删除表
        template.execute("DROP TABLE `tb_book_2`;");
    }
}
