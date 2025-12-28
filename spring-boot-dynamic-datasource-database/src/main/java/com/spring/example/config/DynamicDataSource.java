package com.spring.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.example.bean.ExportDataSource;
import com.spring.example.bean.ExportDataSourceConfig;
import com.spring.example.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
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
    private static Gson gson = new GsonBuilder().create();
    // 业务数据源
    @Autowired
    private DataSourceService dataSourceService;

    // 返回当前数据源标识
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }

    @Override
    public void afterPropertiesSet() {
        // 为 targetDataSources 初始化所有数据源
        Map<Object, Object> targetDataSources = new HashMap<>();
        List<ExportDataSource> dataSources = dataSourceService.getList();
        for (ExportDataSource ds : dataSources) {
            String configJson = ds.getConfig();
            ExportDataSourceConfig config = gson.fromJson(configJson, ExportDataSourceConfig.class);
            DataSource dataSource = createJdbcDataSource(config);
            // 添加数据源
            targetDataSources.put(ds.getId(), dataSource);
        }
        super.setTargetDataSources(targetDataSources);
        // 默认数据源
        super.setDefaultTargetDataSource(orderDataSource);
        super.afterPropertiesSet();
    }

    /**
     * 创建数据源
     * @param config
     * @return
     */
    private DataSource createJdbcDataSource(ExportDataSourceConfig config) {
        DruidDataSource ds = DruidDataSourceBuilder.create().build();
        ds.setDriverClassName(config.getDriver());
        ds.setUrl(buildJdbcUrl(config));
        ds.setUsername(config.getUserName());
        ds.setPassword(config.getPassword());
        return ds;
    }

    /**
     * 构建 JdbcUrl
     * @param config
     * @return
     */
    private String buildJdbcUrl(ExportDataSourceConfig config) {
        DataSourceType type = DataSourceType.fromName(config.getType());
        switch (type) {
            case MYSQL:
                return String.format("jdbc:mysql://%s:%d/%s?useSSL=false",
                        config.getHost(), config.getPort(), config.getDatabase());
            case CLICKHOUSE:
                return String.format("jdbc:clickhouse://%s:%d/%s",
                        config.getHost(), config.getPort(), config.getDatabase());
            case POSTGRESQL:
                return String.format("jdbc:postgresql://%s:%d/%s",
                        config.getHost(), config.getPort(), config.getDatabase());
            default:
                throw new IllegalArgumentException("不支持的JDBC数据源类型");
        }
    }
}
