package com.spring.example.app.di.xml;

import com.spring.example.domain.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：XML 结合注解
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/15 15:13
 */
public class DIXmlAnnotationBeanApp {
    public static void main(String[] args) {
        // 加载配置文件得到上下文对象 即 容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("di/applicationContext-annotation-bean.xml");

        // 引用类型
        Employee employee = (Employee) ctx.getBean("employee");
        System.out.println(employee);
    }
}
