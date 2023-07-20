package com.spring.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 功能：Spring 注解开发模式的配置类
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/16 08:03
 */
@Configuration
@ComponentScan("com.spring.example")
@PropertySource("jdbc.properties")
public class SpringConfig {
}
