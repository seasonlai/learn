package com.season;

import com.season.service.CityDubboConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {  
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CityDubboConsumerService cityDubboConsumerService;

    @Async("mySimpleAsync")
    public Future<String> doTask1() throws InterruptedException{
        logger.info("Task1 started.=====thread_name: {}",Thread.currentThread().getName());
        long start = System.currentTimeMillis();  
        Thread.sleep(5000);
        logger.info("city: {}.=====thread_name: {}",cityDubboConsumerService.getCity(),Thread.currentThread().getName());
        long end = System.currentTimeMillis();  
          
        logger.info("Task1 finished, time elapsed: {} ms. =====thread_name: {}", end-start,Thread.currentThread().getName());
          
        return new AsyncResult<>("Task1 accomplished!");
    }  
      
    @Async("myAsync")
    public Future<String> doTask2() throws InterruptedException{  
        logger.info("Task2 started.=====thread_name: {}",Thread.currentThread().getName());
        long start = System.currentTimeMillis();  
        Thread.sleep(3000);
        logger.info("city: {}.=====thread_name: {}",cityDubboConsumerService.getCity(),Thread.currentThread().getName());
        long end = System.currentTimeMillis();  
          
        logger.info("Task2 finished, time elapsed: {} ms. =====thread_name: {}", end-start,Thread.currentThread().getName());
          
        return new AsyncResult<>("Task2 accomplished!");  
    }  
}  