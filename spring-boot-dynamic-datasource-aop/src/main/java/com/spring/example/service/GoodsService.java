package com.spring.example.service;

import com.spring.example.annotation.DS;
import com.spring.example.bean.DataSourceType;
import com.spring.example.bean.Goods;
import com.spring.example.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 功能：GoodsService
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/29 20:31
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 获取商品列表
     * @return
     */
    @DS(DataSourceType.GOODS)
    public List<Goods> getList() {
        return goodsMapper.selectAll();
    }

    /**
     * 根据商品ID获取商品详细信息
     * @param id
     * @return
     */
    @DS(DataSourceType.GOODS)
    public Optional<Goods> getDetail(Long id) {
        Goods goods = goodsMapper.selectById(id);
        if (goods == null) {
            return Optional.empty();
        }
        return Optional.of(goods);
    }
}
