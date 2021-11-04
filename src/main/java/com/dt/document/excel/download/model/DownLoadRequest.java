package com.dt.document.excel.download.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lucheng
 * @data: 2021/11/2 15:41
 * @version: 1.0
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownLoadRequest {
    private String savePath;
    private String excelPath;
    private Class headerClass;
    private String regEx;
}
