package com.spring.example.mapper.goods;

import com.spring.example.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能：GoodsMapper
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/17 上午12:09
 */
@Mapper
public interface GoodsMapper {
    List<Goods> selectAll();
    Goods selectById(Long id);
}
