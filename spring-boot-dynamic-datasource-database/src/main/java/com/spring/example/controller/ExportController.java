package com.spring.example.controller;

import com.spring.example.service.ExportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：ExportController 人群投递
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:45
 */
@Slf4j
@RestController
@RequestMapping(value = "/export", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExportController {
    @Autowired
    private ExportService exportService;

    @GetMapping(value = "/group")
    public void exportGroup() {
        // 投递到数据源ID下的某个表中
        exportService.exportGroup();
    }
}
