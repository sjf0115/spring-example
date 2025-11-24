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
    private static String clickhouseAddress;

    private static String clickhouseUsername;

    private static String clickhousePassword;

    private static String clickhouseDB;

    private static Integer clickhouseSocketTimeout;

    @Value("${spring.datasource.clickhouse.address}")
    public  void setClickhouseAddress(String address) {
        ClickHouseConfig.clickhouseAddress = address;
    }
    @Value("${spring.datasource.clickhouse.username}")
    public  void setClickhouseUsername(String username) {
        ClickHouseConfig.clickhouseUsername = username;
    }
    @Value("${spring.datasource.clickhouse.password}")
    public  void setClickhousePassword(String password) {
        ClickHouseConfig.clickhousePassword = password;
    }
    @Value("${spring.datasource.clickhouse.db}")
    public  void setClickhouseDB(String db) {
        ClickHouseConfig.clickhouseDB = db;
    }
    @Value("${spring.datasource.clickhouse.socketTimeout}")
    public  void setClickhouseSocketTimeout(Integer socketTimeout) {
        ClickHouseConfig.clickhouseSocketTimeout = socketTimeout;
    }

    public static Connection getConn() {
        Connection conn = null;
        Properties properties = new Properties();
        properties.setProperty("user", clickhouseUsername);
        properties.setProperty("password", clickhousePassword);
        properties.setProperty("db", clickhouseDB);
        try {
            ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource(clickhouseAddress, properties);
            conn = clickHouseDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static List<Map<String,String>> exeSql(String sql){
        log.info("clickhouse 执行sql：" + sql);
        Connection connection = getConn();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsmd = results.getMetaData();
            List<Map<String,String>> list = new ArrayList<>();
            while(results.next()){
                Map<String,String> row = new HashMap<>();
                for(int i = 1;i<=rsmd.getColumnCount();i++){
                    row.put(rsmd.getColumnName(i),results.getString(rsmd.getColumnName(i)));
                }
                list.add(row);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
