package com.spring.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootDruidApplication {
    public static void main(String[] args) {
        log.info("spring boot 与 mybatis 和 druid 集成示例..........");
        SpringApplication.run(SpringBootDruidApplication.class, args);
    }
}
