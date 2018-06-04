package com.season;

import com.season.service.CityDubboConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class LearnDubboApplication {


    static Logger logger = LoggerFactory.getLogger(LearnDubboApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(LearnDubboApplication.class, args);

//        AsyncTask asyncTask = run.getBean(AsyncTask.class);
//
//
//        try {
////			Future<String> doTask1 = asyncTask.doTask1();
////			Future<String> doTask2 = asyncTask.doTask2();
////
////
////			while (!doTask1.isDone()||!doTask2.isDone()){
////				Thread.sleep(1000);
////			}
////
////			logger.info("Task2 result: {}", doTask2.get());
//			logger.info("Task1 result: {}", doTask1.get());
////
//            Future<String> task3 = asyncTask.doTask3();
//            String r = task3.get();
//            logger.info("Task3 result: {}", r);
//            logger.info("All tasks finished.");
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
