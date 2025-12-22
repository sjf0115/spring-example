package com.spring.example.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * 功能：动态数据源
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/22 22:59
 */
// 注解暂时注释掉 当使用 SimpleDynamicDataSource 时再放开
// @Component
// @Primary // 设置为主要注入的 Bean 数据源
public class SimpleDynamicDataSource implements DataSource, InitializingBean {
    // 当前使用的数据源标识
    public static ThreadLocal<String> name = new ThreadLocal<>();
    // 订单数据源
    @Autowired
    private DataSource orderDataSource;
    // 商品数据源
    @Autowired
    private DataSource goodsDataSource;

    @Override
    public Connection getConnection() throws SQLException {
        if (name.get().equals("order")) {
            return orderDataSource.getConnection();
        } else if (name.get().equals("goods")){
            return goodsDataSource.getConnection();
        }
        throw new RuntimeException("非法数据源：" + name.get());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 初始化 默认数据源
        name.set("order");
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        // 暂时不需要
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        // 暂时不需要
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // 暂时不需要
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // 暂时不需要
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        // 暂时不需要
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        // 暂时不需要
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // 暂时不需要
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // 暂时不需要
        return null;
    }
}
