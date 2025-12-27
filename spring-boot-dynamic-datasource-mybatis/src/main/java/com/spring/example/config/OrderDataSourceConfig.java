package com.spring.example.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 功能：订单数据源配置类
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/29 23:16
 */
@Configuration
@MapperScan(
        // 包路径下扫描 Mapper 接口
        basePackages = "com.spring.example.mapper.order",
        // 使用哪个 SqlSessionFactory
        sqlSessionFactoryRef = "orderSqlSessionFactory"
)
public class OrderDataSourceConfig {
    // 订单数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.order")
    public DataSource orderDataSource() {
        // 底层会自动拿到 spring.datasource.order 中的配置创建一个 DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "orderSqlSessionFactory")
    @Primary
    public SqlSessionFactory orderSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 设置数据源
        sessionFactory.setDataSource(orderDataSource());
        // 加载XML映射文件
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mapper/order/*.xml"));

        // 可选但建议的配置
        sessionFactory.setTypeAliasesPackage("com.spring.example.bean.order");
        // 可选：配置驼峰命名
        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(configuration);

        return sessionFactory.getObject();
    }
}
