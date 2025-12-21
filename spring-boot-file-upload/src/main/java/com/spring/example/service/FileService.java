package com.spring.example.service;

import com.spring.example.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 功能：FileService 示例
 * 作者：@SmartSi
 * 博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2025/11/26 15:14
 */
@Service
public class FileService {

    @Value("file.upload")
    private String rootLocation = null;

    public String upload(MultipartFile file) {
        // 检查文件是否为空
        if (file.isEmpty()) {
            throw new RuntimeException("无法上传空文件");
        }

        // 验证文件名
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (originalFileName.contains("..")) {
            throw new RuntimeException("抱歉！文件名包含无效的路径序列 " + originalFileName);
        }

        try {
            // 生成唯一的文件名
            String fileExtension = FileUtil.getFileExtension(originalFileName);
            String uniqueFileName = FileUtil.generateUniqueFileName(fileExtension);

            // 保存文件到磁盘
            Path rootLocationPath = Paths.get(rootLocation);
            Path targetLocation = rootLocationPath.resolve(uniqueFileName)
                    .normalize().toAbsolutePath();
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return uniqueFileName;
        } catch (IOException ex) {
            throw new RuntimeException("无法存储文件 " + originalFileName + ". 请重试!", ex);
        }
    }
}
