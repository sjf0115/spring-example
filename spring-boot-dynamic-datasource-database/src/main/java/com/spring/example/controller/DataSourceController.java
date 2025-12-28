package com.spring.example.controller;

import com.spring.example.bean.ExportDataSource;
import com.spring.example.service.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 功能：OrderController 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:45
 */
@Slf4j
@RestController
@RequestMapping(value = "/ds", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataSourceController {
    @Autowired
    private DataSourceService dataSourceService;

    @GetMapping(value = "/list")
    public List<ExportDataSource> getList() {
        List<ExportDataSource> dataSources = dataSourceService.getList();
        return dataSources;
    }

    @GetMapping(value = "/detail")
    public ExportDataSource getDetail(@RequestParam String id) {
        Optional<ExportDataSource> userOptional = dataSourceService.getDetail(id);
        return userOptional.orElse(null);
    }
}
