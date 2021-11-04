package com.dt.document.excel.download.config;

import com.dt.document.excel.download.util.ExcelReaderUtils;
import com.dt.document.excel.download.util.FileDownloadUtils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lucheng
 * @data: 2021/11/2 15:40
 * @version: 1.0
 */
@Configuration
public class DocumentExcelDownloadConfig {
    @Bean
    public ExcelReaderUtils excelReaderUtils() {
        return new ExcelReaderUtils();
    }

    @Bean
    public FileDownloadUtils fileDownloadUtils() {
        return new FileDownloadUtils();
    }
}
