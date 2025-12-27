package com.spring.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能：动态数据源
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/22 22:59
 */
@Component
@Primary // 设置为主要注入的 Bean 数据源
public class DynamicDataSource extends AbstractRoutingDataSource {
    // 订单数据源
    @Autowired
    private DataSource orderDataSource;
    // 商品数据源
    @Autowired
    private DataSource goodsDataSource;

    // 返回当前数据源标识
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }

    @Override
    public void afterPropertiesSet() {
        // 为 targetDataSources 初始化所有数据源
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("order", orderDataSource);
        targetDataSources.put("goods", goodsDataSource);
        super.setTargetDataSources(targetDataSources);
        // 默认数据源
        super.setDefaultTargetDataSource(orderDataSource);
        super.afterPropertiesSet();
    }
}
