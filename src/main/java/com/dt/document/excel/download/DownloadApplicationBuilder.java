package com.dt.document.excel.download;

import com.dt.document.excel.download.model.DownLoadRequest;
import com.dt.document.excel.download.util.FileDownloadUtils;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author: lucheng
 * @data: 2021/11/2 15:45
 * @version: 1.0
 */
public class DownloadApplicationBuilder {
    private final DownLoadRequest downLoadRequest;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private final FileDownloadUtils downloadUtils;

    public DownloadApplicationBuilder(DownLoadRequest downLoadRequest, ThreadPoolTaskExecutor threadPoolTaskExecutor, FileDownloadUtils downloadUtils) {
        this.downLoadRequest = downLoadRequest;
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
        this.downloadUtils = downloadUtils;
    }

    public DownloadApplication build() {
        if(downLoadRequest == null || threadPoolTaskExecutor == null || downloadUtils == null) {
            return null;
        }
        return new DownloadApplication(threadPoolTaskExecutor,
                downLoadRequest.getSavePath(),
                downLoadRequest.getExcelPath(),
                downloadUtils,
                downLoadRequest.getHeaderClass(),
                downLoadRequest.getRegEx());
    }
}
