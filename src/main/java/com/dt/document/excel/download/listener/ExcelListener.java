package com.dt.document.excel.download.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.dt.document.excel.download.model.ExcelDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: lucheng
 * @data: 2021/7/29 16:44
 * @version: 1.0
 */
public class ExcelListener extends AnalysisEventListener<Map<Integer, String>> {
    private static final int BATCH_COUNT = 2;
    List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>(BATCH_COUNT);

    @Override
    public void invoke(Map<Integer, String> integerStringMap, AnalysisContext analysisContext) {
        //integerStringMap.put(0,"1");
        list.add(integerStringMap);
        if(list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }



    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        System.out.println("done!");
    }

    private void saveData(){
        System.out.println(list.size()+"success");
        System.out.println(list.toString()+"sss");
    }
}
