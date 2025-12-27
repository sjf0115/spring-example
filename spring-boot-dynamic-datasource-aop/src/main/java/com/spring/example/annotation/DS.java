package com.spring.example.annotation;

import com.spring.example.bean.DataSourceType;

import java.lang.annotation.*;

/**
 * 功能：数据源注解  用于在方法或类上指定使用的数据源
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/27 19:40
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DS {
    // 默认数据源-订单数据源
    DataSourceType value() default DataSourceType.ORDER;
}
