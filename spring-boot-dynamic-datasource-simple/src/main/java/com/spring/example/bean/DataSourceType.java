package com.spring.example.bean;

/**
 * 功能：数据源枚举
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/27 15:52
 */
public enum DataSourceType {
    /**
     * 订单数据源
     */
    ORDER("order"),

    /**
     * 商品数据源
     */
    GOODS("goods");

    private final String name;

    DataSourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
