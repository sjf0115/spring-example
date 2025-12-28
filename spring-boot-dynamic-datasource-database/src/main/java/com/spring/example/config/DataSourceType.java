package com.spring.example.config;

/**
 * 功能：数据源类型
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/27 15:52
 */
public enum DataSourceType {
    // MYSQL 数据库
    MYSQL("mysql", "com.mysql.cj.jdbc.Driver"),
    CLICKHOUSE("clickhouse", ""),
    POSTGRESQL("POSTGRESQL", "");

    private final String name;
    private final String driver;

    DataSourceType(String name, String driver) {
        this.name = name;
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public String getDriver() {
        return driver;
    }

    /**
     * 根据名称获取枚举
     */
    public static DataSourceType fromName(String name) {
        for (DataSourceType type : DataSourceType.values()) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("未知的数据源类型: " + name);
    }
}
