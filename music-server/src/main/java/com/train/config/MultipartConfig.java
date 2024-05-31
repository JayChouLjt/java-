package com.train.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MultipartConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        // 设置单个文件的最大上传大小
        factory.setMaxFileSize(DataSize.ofMegabytes(20)); // 20MB
        // 设置总上传数据的总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(50)); // 50MB
        // 设置文件上传的临时文件夹
        factory.setLocation("/tmp/uploads");
        // 其他配置选项可以根据需要添加
        // factory.setFileSizeThreshold(DataSize.ofKilobytes(512)); // 超过这个大小则写入磁盘
        return factory.createMultipartConfig();
    }

}
