package com.mybatis.example.mapper;

import com.mybatis.example.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能：UserMapper
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/17 上午12:09
 */
public interface UserMapper {
    List<User> selectAll();
    User selectById(@Param("id") int id);
}
