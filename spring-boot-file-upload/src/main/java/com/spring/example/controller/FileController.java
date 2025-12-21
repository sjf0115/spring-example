package com.spring.example.controller;

import com.spring.example.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 功能：FileController
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/4/24 下午11:26
 */
@RestController
@RequestMapping(value = "/file", produces = MediaType.APPLICATION_JSON_VALUE)
public class FileController {
    private static Logger LOG = LoggerFactory.getLogger(FileController.class);
    @Resource
    private FileService fileService;

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        LOG.info("开始上传文件: {}", file.getOriginalFilename());
        String fileName = fileService.upload(file);
        LOG.info("文件上传成功: {}", fileName);
        return fileName;
    }
}
