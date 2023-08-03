package com.spring.example.jdbc.operations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * 功能： JDBCTemplate 通过 Spring XML 注入 --- INSERT
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/20 07:47
 */
public class JDBCTemplateInsertExample {

    // 1. 无参数
    private static void insert1(JdbcTemplate template, String sql) {
        int nums = template.update(sql);
        System.out.println("成功插入" + nums + "条记录");
    }

    // 2. 有参数 使用占位符
    private static void insert2(JdbcTemplate template, String sql) {
        String type = "计算机理论";
        String name = "深入理解 JdbcTemplate";
        String desc = "2";
        int nums2 = template.update(sql, type, name, desc);
        System.out.println("成功插入" + nums2 + "条记录");
    }

    // 3. 有参数 使用占位符 PreparedStatementSetter
    private static void insert3(JdbcTemplate template, String sql) {
        String type = "计算机理论";
        String name = "深入理解 JdbcTemplate";
        String desc = "3";
        int nums3 = template.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, type);
                ps.setString(2, name);
                ps.setString(3, desc);
            }
        });
        System.out.println("成功插入" + nums3 + "条记录");
    }

    // 4. 有参数 使用占位符 获取自增值
    private static void insert4(JdbcTemplate template, String sql) {
        String type = "计算机理论";
        String name = "深入理解 JdbcTemplate";
        String desc = "4";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int nums4 = template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                //手动创建PreparedStatement，注意第二个参数：Statement.RETURN_GENERATED_KEYS
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, type);
                ps.setString(2, name);
                ps.setString(3, desc);
                return ps;
            }
        }, keyHolder);
        System.out.println("成功插入" + nums4 + "条记录");
        System.out.println("新记录id：" + keyHolder.getKey().intValue());
    }

    // 5. 插入操作-批量插入
    private static void insert5(JdbcTemplate template, String sql) {
        List<Object[]> books = Arrays.asList(
                new Object[]{"计算机理论", "深入理解 JdbcTemplate", "51"},
                new Object[]{"计算机理论", "深入理解 JdbcTemplate", "52"},
                new Object[]{"计算机理论", "深入理解 JdbcTemplate", "53"},
                new Object[]{"计算机理论", "深入理解 JdbcTemplate", "54"});
        int[] numsBatch = template.batchUpdate(sql, books);
        for (int num : numsBatch) {
            System.out.println("批量插入" + num + "条记录");
        }
    }


    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
        // 获取 JDBCTemplate 数据源是通过 XML 注入
        JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql = "INSERT INTO tb_book (type, name, description) VALUES('计算机理论', '深入理解 JdbcTemplate', '1')";
        String placeholderSQL = "INSERT INTO tb_book (type, name, description) VALUES(?, ?, ?)";

        // 1. 无参数
        // insert1(template, sql);

        // 2. 有参数 使用占位符
        // insert2(template, placeholderSQL);

        // 3. 有参数 使用占位符 PreparedStatementSetter
        // insert3(template, placeholderSQL);

        // 4. 有参数 使用占位符 获取自增值
        // insert4(template, placeholderSQL);

        // 5. 插入操作-批量插入
        insert5(template, placeholderSQL);
    }
}
