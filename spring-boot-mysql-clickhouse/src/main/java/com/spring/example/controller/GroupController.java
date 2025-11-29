package com.spring.example.controller;

import com.spring.example.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：GroupController 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:45
 */
@Slf4j
@RestController
@RequestMapping(value = "/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping(value = "/size")
    public int getGroupSize(@RequestParam Long groupId) {
        return groupService.groupSize(groupId);
    }

    @GetMapping(value = "/contain")
    public boolean contain(@RequestParam Long groupId, @RequestParam Long userId) {
        return groupService.contain(groupId, userId);
    }
}
