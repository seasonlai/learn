package com.season.config;

import org.apache.tomcat.util.threads.TaskThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/5/9.
 */
@Configuration
public class ThreadPool {

    /**
     * Set the ThreadPoolExecutor's core pool size.
     */
    private static final int corePoolSize = 10;
    /**
     * Set the ThreadPoolExecutor's maximum pool size.
     */
    private static final int maxPoolSize = 200;
    /**
     * Set the capacity for the ThreadPoolExecutor's BlockingQueue.
     */
    private static final int queueCapacity = 20;

    @Bean
    public ThreadPoolExecutor getThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCapacity));
        executor.setThreadFactory(new TaskThreadFactory("consumer-",false,1));
        return executor;
    }
}
