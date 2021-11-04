package com.dt.document.excel.download.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.dt.document.excel.download.annotation.ExcelColumn;

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
    @ExcelColumn(index = 0)
    private Long id;

    @ExcelColumn(index = 1)
    private String productName;

    @ExcelColumn(index = 4)
    private String subject;

    @ExcelColumn(index = 3)
    private String stage;

    @ExcelColumn(index = 2)
    private String author;

    @ExcelColumn(index = 5)
    private String phone;

    @ExcelColumn(index = 6)
    private String area;

    private String school;

    @ExcelColumn(type = "list", fromIndex = 7, toIndex = 15)
    private List<String> fileUrls;


}
