package com.spring.example.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 功能：示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/24 23:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ClickHouseConfigTest {
    @Resource
    private ClickHouseConfig config;

    @Test
    public void exeSql() {
        log.info("===========测试开始============");
        String sql="select id, name, age from user";
        List<Map<String,String>> result= config.exeSql(sql);
        log.info("===========查询技术============");
        log.info("clickhouse查询结果为：{}",result);
    }
}
