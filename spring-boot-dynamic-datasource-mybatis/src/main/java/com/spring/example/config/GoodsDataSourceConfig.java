package com.spring.example.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 功能：商品数据源配置类
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/29 23:16
 */
@Configuration
@MapperScan(basePackages = "com.spring.example.mapper.goods",
        sqlSessionFactoryRef = "goodsSqlSessionFactory")
public class GoodsDataSourceConfig {
    // 商品数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.goods")
    public DataSource goodsDataSource() {
        // 底层会自动拿到 spring.datasource.order 中的配置创建一个 DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory goodsSqlSessionFactory(@Qualifier("goodsDataSource") DataSource goodsDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(goodsDataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mapper/goods/*.xml"));
        return sessionFactory.getObject();
    }
}
