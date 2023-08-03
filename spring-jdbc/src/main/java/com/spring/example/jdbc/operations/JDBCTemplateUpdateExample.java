package com.spring.example.jdbc.operations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 功能： JDBCTemplate 通过 Spring XML 注入 --- Update
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/20 07:47
 */
public class JDBCTemplateUpdateExample {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
        // 获取 JDBCTemplate 数据源是通过 XML 注入
        JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        // 执行 SQL
        String name = "深入理解 JdbcTemplate";
        int id = 26;
        int nums = template.update("Update tb_book SET name = ? WHERE id = ?", name, id);
        System.out.println("成功更新" + nums + "条记录");
    }
}
