package com.spring.example.config;

import com.clickhouse.jdbc.ClickHouseDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

/**
 * 功能：ClickHouse 配置类
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/16 08:03
 */
@Slf4j
@Component
public class ClickHouseConfig {
    private static String url;
    private static String userName;
    private static String password;
    private static String dB;

    @Value("${spring.datasource.url}")
    public  void setClickhouseAddress(String address) {
        ClickHouseConfig.url = address;
    }

    @Value("${spring.datasource.username}")
    public  void setClickhouseUsername(String username) {
        ClickHouseConfig.userName = username;
    }

    @Value("${spring.datasource.password}")
    public  void setClickhousePassword(String password) {
        ClickHouseConfig.password = password;
    }

    @Value("${spring.datasource.db}")
    public  void setClickhouseDB(String db) {
        ClickHouseConfig.dB = db;
    }

    // 获取 Connection
    public Connection getConn() {
        Connection conn = null;
        Properties properties = new Properties();
        properties.setProperty("user", userName);
        properties.setProperty("password", password);
        try {
            ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource(url, properties);
            conn = clickHouseDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    /**
     * 执行 SQL
     * @param sql
     * @return
     */
    public List<Map<String,String>> exeSql(String sql){
        log.info("ClickHouseConfig 执行 sql：{}", sql);

        List<Map<String,String>> result = new ArrayList<>();
        Connection connection = getConn();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()) {
                Map<String,String> row = new HashMap<>();
                for(int i = 1; i <= metaData.getColumnCount(); i++){
                    row.put(metaData.getColumnName(i), rs.getString(metaData.getColumnName(i)));
                }
                result.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
