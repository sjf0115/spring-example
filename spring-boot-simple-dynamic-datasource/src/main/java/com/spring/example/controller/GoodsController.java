package com.spring.example.controller;

import com.spring.example.bean.DynamicDataSource;
import com.spring.example.bean.Goods;
import com.spring.example.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 功能：GoodsController 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:45
 */
@Slf4j
@RestController
@RequestMapping(value = "/goods", produces = MediaType.APPLICATION_JSON_VALUE)
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "/list")
    public List<Goods> getList() {
        DynamicDataSource.name.set("goods");
        return goodsService.getList();
    }

    @GetMapping(value = "/detail")
    public Goods getDetail(@RequestParam Long id) {
        DynamicDataSource.name.set("goods");
        Optional<Goods> goodsOptional = goodsService.getDetail(id);
        return goodsOptional.orElse(null);
    }
}
