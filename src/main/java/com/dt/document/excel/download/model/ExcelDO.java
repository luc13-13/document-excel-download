package com.dt.document.excel.download.model;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: lucheng
 * @data: 2021/7/29 16:25
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExcelDO {
    private Long id;
    private String productName;
    private String subject;
    private String stage;
    private String author;
    private String phone;
    private String area;
    private String school;

    private List<String> fileUrls;


}
