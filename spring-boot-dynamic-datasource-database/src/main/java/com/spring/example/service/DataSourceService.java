package com.spring.example.service;

import com.spring.example.bean.ExportDataSource;
import com.spring.example.mapper.DataSourceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 功能：数据源服务
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 21:42
 */
@Service
public class DataSourceService {
    @Resource
    private DataSourceMapper dataSourceMapper;

    /**
     * 获取数据源列表
     * @return
     */
    public List<ExportDataSource> getList() {
        List<ExportDataSource> dataSources = dataSourceMapper.selectAll();
        return dataSources;
    }

    /**
     * 根据数据源ID获取数据眼详细信息
     * @param dataSourceId
     * @return
     */
    public Optional<ExportDataSource> getDetail(String dataSourceId) {
        ExportDataSource dataSource = dataSourceMapper.selectById(dataSourceId);
        if (dataSource == null) {
            return Optional.empty();
        }
        return Optional.of(dataSource);
    }
}
