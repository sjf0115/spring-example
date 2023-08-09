package com.spring.example.jdbc.operations;

import com.spring.example.domain.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    // 多行多列 借助 RowMapper 返回 JavaBean 对象
    public static void queryRowMapper(JdbcTemplate template) {
        String sql = "SELECT id, type, name, description FROM tb_book WHERE id > ?";
        List<Book> books = template.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setType(rs.getString(2));
                b.setName(rs.getString(3));
                b.setDescription(rs.getString(4));
                return b;
            }
        }, 10);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // 多行多列 借助 ResultSetExtractor 返回 JavaBean 对象
    public static void queryResultSetExtractor(JdbcTemplate template) {
        String sql = "SELECT id, type, name, description FROM tb_book WHERE id > ?";
        List<Book> books = template.query(sql, new ResultSetExtractor<List<Book>>() {
            @Override
            public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Book> books = new ArrayList<>();
                while (rs.next()) {
                    Book b = new Book();
                    b.setId(rs.getInt(1));
                    b.setType(rs.getString(2));
                    b.setName(rs.getString(3));
                    b.setDescription(rs.getString(4));
                    books.add(b);
                }
                return books;
            }
        }, 10);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // 多行多列 借助 RowCallbackHandler 输出 JavaBean 对象
    public static void queryRowCallbackHandler(JdbcTemplate template) {
        String sql = "SELECT id, type, name, description FROM tb_book WHERE id > ?";
        template.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt(1));
                    book.setType(rs.getString(2));
                    book.setName(rs.getString(3));
                    book.setDescription(rs.getString(4));
                    System.out.println(book);
                }
            }
        },10);
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
        String sql = "SELECT id, name, type FROM tb_book WHERE id = ?";
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

        // queryForObject(template);

        // queryForObjectRowMapper(template);

        // queryForList(template);

        queryForMap(template);

        // queryForRowSet(template);

        // queryRowMapper(template);

        // queryResultSetExtractor(template);

        // queryRowCallbackHandler(template);
    }
}
