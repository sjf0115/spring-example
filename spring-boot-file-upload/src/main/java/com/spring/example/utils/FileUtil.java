package com.spring.example.utils;

import java.util.UUID;

/**
 * 功能：文件工具类
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/12/20 13:31
 */
public class FileUtil {
    /**
     * 文件类型
     * @param filename
     * @return
     */
    public static String getFileExtension(String filename) {
        return filename != null && filename.contains(".")
                ? filename.substring(filename.lastIndexOf("."))
                : "";
    }

    /**
     * 生成唯一文件名称
     * @param extension
     * @return
     */
    public static String generateUniqueFileName(String extension) {
        return UUID.randomUUID() + extension;
    }
}
