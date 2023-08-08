package com.spring.example.jdbc.operations;

import com.spring.example.domain.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 功能： JDBCTemplate 通过 Spring XML 注入 --- SELECT
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/20 07:47
 */
public class JDBCTemplateSelectExample {

    // 多行多列
    public static void query(JdbcTemplate template) {
        String sql = "SELECT id, type, name, description FROM tb_book WHERE id > ?";
        template.query(sql);
    }



    // 单行单列 返回单值对象
    public static void queryForObject(JdbcTemplate template) {
        String sql = "SELECT name FROM tb_book WHERE id = ?";
        String name = template.queryForObject(sql, String.class, 1);
        System.out.println(name);
    }

    // 单行多列 借助 RowMapper 返回 JavaBean 对象
    public static void queryForObjectRowMapper(JdbcTemplate template) {
        String sql = "SELECT id, type, name, description FROM tb_book WHERE id = ?";
        Book book = template.queryForObject(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setType(rs.getString(2));
                b.setName(rs.getString(3));
                b.setDescription(rs.getString(4));
                return b;
            }
        }, 1);
        System.out.println(book);
    }

    // 多行单列 返回单值List对象
    public static void queryForList(JdbcTemplate template) {
        String sql = "SELECT name FROM tb_book WHERE id > ?";
        List<String> list = template.queryForList(sql, String.class, 30);
        System.out.println(list);
    }

    // 多行单列 返回单值Map对象
    public static void queryForMap(JdbcTemplate template) {
        String sql = "SELECT name FROM tb_book WHERE id > ?";
        Map<String, Object> map = template.queryForMap(sql, 30);
        for (String k : map.keySet()) {
            System.out.println(k + ":" + map.get(k));
        }
    }

    // 多行多列 返回 SqlRowSet 对象
    public static void queryForRowSet(JdbcTemplate template) {
        String sql = "SELECT id, type, name FROM tb_book WHERE id > ?";
        SqlRowSet rowSet = template.queryForRowSet(sql, 30);
        while (rowSet.next()) {
            int id = rowSet.getInt(1);
            String type = rowSet.getString(2);
            String name = rowSet.getString(3);
            System.out.println("ID: " + id + ", type: " + type + ", name: " + name);
        }
    }

    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
        // 获取 JDBCTemplate 数据源是通过 XML 注入
        JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        // 1. 单行单列
        // queryForObject(template);

        queryForObjectRowMapper(template);


        // 2. 多行单列
        // queryForList(template);

        // queryForMap(template);

        // queryForRowSet(template);
    }
}
