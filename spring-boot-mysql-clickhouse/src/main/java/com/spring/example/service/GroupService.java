package com.spring.example.service;

import com.spring.example.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能：GroupService
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/29 20:31
 */
@Service
public class GroupService {
    @Autowired
    private GroupDao groupDao;

    // 根据群组 ID 查询群组对应表用户规模
    public int groupSize(Long groupId) {
        return groupDao.groupSize(groupId);
    }

    // 判断群组中是否包含对应的用户
    public boolean contain(Long groupId, Long userId) {
        return groupDao.contain(groupId, userId);
    }
}
