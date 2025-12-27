package com.spring.example.aspect;

import com.spring.example.annotation.DS;
import com.spring.example.bean.DataSourceContextHolder;
import com.spring.example.bean.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 功能：动态数据源切面
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/27 19:47
 */
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {
    // 定义切点：所有被@DS注解的方法
    @Pointcut("@annotation(com.spring.example.annotation.DS)")
    public void dynamicDataSourcePointcut() {
    }

    // 在方法执行前切换数据源
    @Before("dynamicDataSourcePointcut()")
    public void before(JoinPoint point) throws Throwable {
        // 获取方法上的@DS注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DS dsAnnotation = method.getAnnotation(DS.class);
        if (dsAnnotation == null) {
            // 如果方法上没有，尝试获取类上的注解
            Class<?> targetClass = point.getTarget().getClass();
            dsAnnotation = targetClass.getAnnotation(DS.class);
        }
        // 切换数据源
        if (Objects.nonNull(dsAnnotation)) {
            DataSourceType dataSourceType = dsAnnotation.value();
            log.debug("切换数据源到: {}，方法: {}", dataSourceType.getName(), method.getName());
            DataSourceContextHolder.setDataSource(dataSourceType);
        }
    }

    // 在方法执行后清除数据源设置
    @After("dynamicDataSourcePointcut()")
    public void after(JoinPoint joinPoint) {
        DataSourceContextHolder.removeDataSource();
        log.debug("清除数据源设置，方法: {}", joinPoint.getSignature().getName());
    }
}
