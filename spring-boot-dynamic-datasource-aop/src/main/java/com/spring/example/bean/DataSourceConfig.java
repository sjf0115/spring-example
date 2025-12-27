package com.spring.example.bean;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 功能：数据源配置类
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/29 23:16
 */
@Configuration
public class DataSourceConfig {

    // 订单数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.order")
    public DataSource orderDataSource() {
        // 底层会自动拿到 spring.datasource.order 中的配置创建一个 DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }

    // 商品数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.goods")
    public DataSource goodsDataSource() {
        // 底层会自动拿到 spring.datasource.order 中的配置创建一个 DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }
}
