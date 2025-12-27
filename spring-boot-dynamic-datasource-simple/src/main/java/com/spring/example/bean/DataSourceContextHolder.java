package com.spring.example.bean;

/**
 * 功能：DataSourceContextHolder ThreadLocal存放数据源变量
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/27 15:27
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<DataSourceType> DATASOURCE_HOLDER = new ThreadLocal<>();

    /**
     * 获取当前线程的数据源
     * @return
     */
    public static DataSourceType getDataSource() {
        return DATASOURCE_HOLDER.get();
    }

    /**
     * 设置数据源
     * @param dataSourceType
     */
    public static void setDataSource(DataSourceType dataSourceType) {
        DATASOURCE_HOLDER.set(dataSourceType);
    }

    /**
     * 删除当前数据源
     */
    public static void removeDataSource() {
        DATASOURCE_HOLDER.remove();
    }
}
