package com.dt.document.excel.download.util;

import com.alibaba.excel.EasyExcel;
import com.dt.document.excel.download.listener.ExcelListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author: lucheng
 * @data: 2021/7/29 17:15
 * @version: 1.0
 */
public class ExcelReaderUtils {
    public static List<Map<Integer, String>> read(String filepath) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filepath);
            List<Map<Integer, String>> res = EasyExcel.read(inputStream, new ExcelListener()).sheet().doReadSync();
            return res;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

}
