package com.dt.document.excel.download;

import com.dt.document.excel.download.model.ExcelDO;
import com.dt.document.excel.download.util.ExcelReaderUtils;
import com.dt.document.excel.download.util.FileDownloadUtils;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: lucheng
 * @data: 2021/11/2 15:45
 * @version: 1.0
 */
public class DownloadApplication {
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private final String savePath;
    private final String excelPath;
    private final FileDownloadUtils downloadUtils;
    private final Class T;
    private final String regEx;

    public DownloadApplication(ThreadPoolTaskExecutor threadPoolTaskExecutor,
                               String savePath,
                               String excelPath,
                               FileDownloadUtils downloadUtils,
                               Class T,
                               String regEx) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
        this.savePath = savePath;
        this.excelPath = excelPath;
        this.downloadUtils = downloadUtils;
        this.T = T;
        this.regEx = regEx;
    }

    public void run() throws Exception {
        if(!check()) {
            throw new Exception("请检查excel和文件保存路径");
        }
        List<Map<Integer, String>> result = loadExcel();
        ExcelDO excelDO;
        for(Map<Integer, String> map : result) {
            excelDO = ExcelDO.builder()
                    .id(Long.parseLong(map.get(0)))
                    .productName(map.get(1))
                    .author(map.get(2))
                    .stage(map.get(3))
                    .subject(map.get(4))
                    .phone(map.get(5))
                    .area(map.get(6))
                    //.school(map.get(7))
                    .fileUrls(new ArrayList<String>(map.values()).subList(7,map.size()))
                    .build();

            //System.out.println(excelDO.toString());
            String directory = "";
            // 没有学段名的，保存在 其它\ 目录下
            // 有学段名没有学科名的，保存在 学段名\其它 目录下
            if(excelDO.getStage() == null) {
                directory = "其它";
            }
            else if(excelDO.getSubject() == null) {
                directory = excelDO.getStage()+"\\"+"其它"+"\\"+(excelDO.getProductName().replaceAll(regEx,""));
            }
            else {
                directory = excelDO.getStage()+"\\"+excelDO.getSubject()+"\\"+(excelDO.getProductName().replaceAll(regEx,""));
            }

            checkDirectory(directory);
            System.out.println(directory);
            for(String url : excelDO.getFileUrls()) {
                String finalDirectory = directory;
                this.threadPoolTaskExecutor.submit(() -> downloadUtils.downLoad(url, savePath+ "\\" + finalDirectory));
            }
        }
    }

    private List<Map<Integer, String>> loadExcel() {
        return ExcelReaderUtils.read(excelPath);
    }

    public boolean check() {
        if (this.threadPoolTaskExecutor == null
                || this.savePath == null
                || this.excelPath == null
                || this.downloadUtils == null) {
            return false;
        }
        return true;
    }

    private boolean checkDirectory(String directory) {
        boolean state = true;
        File file = new File(savePath + "\\" + directory);
        if(!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                System.out.println("=============create directory failure:" + directory);
            }

            System.out.println("=============create directory done:" + directory);
            state = false;
        }
        return state;
    }
}
