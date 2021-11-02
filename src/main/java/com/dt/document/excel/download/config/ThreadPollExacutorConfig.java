package com.dt.document.excel.download.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: lucheng
 * @data: 2021/11/2 12:03
 * @version: 1.0
 */
public class ThreadPollExacutorConfig {
    public ThreadPoolTaskExecutor getThreadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.initialize();
        //线程池核心线程数
        threadPoolTaskExecutor.setCorePoolSize(8);
        //线程池最大线程数 等待队列满之后开启
        threadPoolTaskExecutor.setMaxPoolSize(12);
        //队列数，默认 Integer.MAX 大于0为LinkedBlockingQueue 小于等于0为 SynchronousQueue
        threadPoolTaskExecutor.setQueueCapacity(100);
        //达到最大线程数后续任务在主线程中执行策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //开启核心线程数支持空闲释放
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        //设置等待任务完成后再关闭
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return threadPoolTaskExecutor;
    }
}
