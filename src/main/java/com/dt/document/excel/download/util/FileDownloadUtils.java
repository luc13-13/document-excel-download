package com.dt.document.excel.download.util;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: lucheng
 * @data: 2021/7/29 16:12
 * @version: 1.0
 */
public class FileDownloadUtils {

    public void downLoad(String url, String savePath) {
        URL myurl;
        URLConnection connection;
        String filename;
        File output;
        try {
            myurl = new URL(url);
            connection = myurl.openConnection();
            connection.connect();

            if(((HttpURLConnection) connection).getResponseCode() == 200) {
                filename = URLDecoderString(connection.getHeaderField("Content-Disposition"));
                output = new File(savePath +"\\" + filename.substring(filename.lastIndexOf('=') + 1));
                Long start = System.currentTimeMillis();
                if(!output.exists() || output.length() != connection.getContentLengthLong()) {
                    InputStream inputStream = connection.getInputStream();
                    System.out.println("===========DownLoading:" + output.getName());
                    //byte[] data = readInputStream(inputStream);
                    BufferedOutputStream bfos = null;
                    FileOutputStream fos = null;
                    try{
                        if(output.exists()) {
                            output = new File(savePath +"\\" + "append" +filename.substring(filename.lastIndexOf('=') + 1) );
                            if(output.exists()){
                                throw new Exception("exists!");
                            }
                        }
                        fos = new FileOutputStream(output);

                        readInputStream(inputStream, fos);
                    } catch (Exception e) {

                    } finally {
                        //if(inputStream != null) {
                            inputStream.close();
                        //}
                        //if(fos != null) {
                            fos.close();
                       // }

                    }

                }
                Long end = System.currentTimeMillis();
                System.out.println("===ElapsedTime:"+((end-start)/60000)+"minutes===Done:" +filename +"!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
    private void readInputStream(InputStream inputStream, FileOutputStream fos) throws IOException {
        byte[] buffer = new byte[1024*1024*10];
        int len = 0;
        BufferedOutputStream bos = new BufferedOutputStream(fos,1024*1024*10);
        System.out.print("===========DownLoading=========");
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
    }




//    public static String getURLEncoderString(String str) {
//        String result = "";
//        if (null == str) {
//            return "";
//        }
//        try {
//            result = java.net.URLEncoder.encode(str, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    private String URLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
