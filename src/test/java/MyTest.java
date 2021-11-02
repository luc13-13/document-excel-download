import com.alibaba.excel.EasyExcel;
import com.dt.document.excel.download.config.ThreadPollExacutorConfig;
import com.dt.document.excel.download.listener.ExcelListener;
import com.dt.document.excel.download.model.ExcelDO;
import com.dt.document.excel.download.util.ExcelReaderUtils;
import com.dt.document.excel.download.util.FileDownloadUtils;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * @author: lucheng
 * @data: 2021/7/29 16:02
 * @version: 1.0
 */


public class MyTest {
    public static void main(String[] args) {
//        String filepath = "E:\\Testdocuments\\十四五大赛.xlsx";
//        List<Map<Integer, String>> result = ExcelReaderUtils.read(filepath);
//        System.out.println(result.toString());
//        System.out.println("================Excel Reading Finish!============");
//        System.out.println("================Start DownLoading");
//        String savepath = "E:\\Testdocuments\\downLoad";
//        ExcelDO excelDO = null;
//        String regEx = "[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
//        Pattern p = Pattern.compile(regEx);
//        FileDownloadUtils downloadUtils = new FileDownloadUtils();
//        ThreadPoolTaskExecutor executor = new ThreadPollExacutorConfig().getThreadPoolExecutor();
//        for(Map<Integer, String> map : result) {
//            excelDO = ExcelDO.builder()
//                    .id(Long.parseLong(map.get(0)))
//                    .productName(map.get(1))
//                    .author(map.get(2))
//                    .stage(map.get(3))
//                    .subject(map.get(4))
//                    .phone(map.get(5))
//                    .area(map.get(6))
//                    .fileUrls(new ArrayList<String>(map.values()).subList(7,map.size()))
//                    .build();
//
//            String directory = "";
//            // 没有学段名的，保存在 其它\ 目录下
//            // 有学段名没有学科名的，保存在 学段名\其它 目录下
//            if(excelDO.getStage() == null) {
//                directory = "其它";
//            }
//            else if(excelDO.getSubject() == null) {
//                directory = excelDO.getStage()+"\\"+"其它"+"\\"+(excelDO.getProductName().replaceAll(regEx,""));
//            }
//            else {
//                directory = excelDO.getStage()+"\\"+excelDO.getSubject()+"\\"+(excelDO.getProductName().replaceAll(regEx,""));
//            }
//
//            checkDirectory(savepath, directory);
//            System.out.println(directory);
//            for(String url : excelDO.getFileUrls()) {
//                String finalDirectory = directory;
//                executor.submit(() -> downloadUtils.downLoad(url, savepath+ "\\" + finalDirectory));
//
//            }
//
//        }

    }
    // check directory exist

//    public static boolean checkDirectory(String rootpath, String directory) {
//        boolean state = true;
//        File file = new File(rootpath + "\\" + directory);
//        if(!file.exists()) {
//            try {
//                file.mkdirs();
//            } catch (Exception e) {
//                System.out.println("=============create directory failure:" + directory);
//            }
//
//            System.out.println("=============create directory done:" + directory);
//            state = false;
//        }
//        return state;
//    }

//    public void Func01() throws Exception {
//        String url = "http://hydrology.princeton.edu/data/pgf/v2/0.5deg/3hourly/dswrf_3hourly_1911-1911.nc";
//        URL myurl = new URL(url);
//        URLConnection connection = myurl.openConnection();
//        connection.connect();
//        InputStream inputStream = null;
//        FileOutputStream fos = null;
//        BufferedOutputStream bfos = null;
//        try {
//            inputStream = connection.getInputStream();
//            fos = new FileOutputStream(new File("D:\\DATA_CMIP6\\test.nc"));
//            bfos = new BufferedOutputStream(fos, 1024 * 1024 * 10);
//            int len = 0;
//            byte[] buffer = new byte[1024 * 1024 * 10];
//            System.out.println("downloading=========");
//            while ((len = inputStream.read(buffer)) != -1) {
//                bfos.write(buffer, 0, len);
//            }
//            bfos.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            fos.close();
//            inputStream.close();
//        }
//    }

}
