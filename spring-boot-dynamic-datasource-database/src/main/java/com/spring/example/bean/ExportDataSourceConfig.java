package com.spring.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能：投递数据源配置
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/28 22:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExportDataSourceConfig {
    private String type;
    private String host;
    private int port;
    private String database;
    private String userName;
    private String password;
    private String driver;
}
