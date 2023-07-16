package com.spring.example.app.di.annotation;

import com.spring.example.config.SpringConfig;
import com.spring.example.domain.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 功能：依赖注入-注解开发模式-配置类代替配置文件
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/11 07:55
 */
public class AnnotationConfigApp {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 引用类型
        Employee employee = (Employee) ctx.getBean("employee");
        System.out.println(employee);
    }
}
