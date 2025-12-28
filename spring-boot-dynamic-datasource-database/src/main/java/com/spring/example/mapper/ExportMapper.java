package com.spring.example.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 功能：ExportMapper
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/17 上午12:09
 */
@Mapper
public interface ExportMapper {
    int insert(String id);
}
