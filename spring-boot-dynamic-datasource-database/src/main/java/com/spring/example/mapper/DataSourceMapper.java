package com.spring.example.mapper;

import com.spring.example.bean.ExportDataSource;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 功能：DataSourceMapper
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/17 上午12:09
 */
@Mapper
public interface DataSourceMapper {
    List<ExportDataSource> selectAll();
    ExportDataSource selectById(String id);
}
