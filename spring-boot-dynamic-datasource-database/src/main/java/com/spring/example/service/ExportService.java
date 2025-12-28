package com.spring.example.service;

import com.spring.example.mapper.ExportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：ExportService
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/29 20:31
 */
@Service
public class ExportService {
    @Autowired
    private ExportMapper exportMapper;

    // 模拟投递人群
    public void exportGroup() {
        List<String> users = new ArrayList<>();
        users.add("a");
        users.add("b");
        users.add("c");
        for (String user : users) {
            exportMapper.insert(user);
        }
    }
}
