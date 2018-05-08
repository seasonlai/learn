package com.season;

import com.season.service.CityDubboConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
public class LearnDubboApplication {


	static Logger logger = LoggerFactory.getLogger(LearnDubboApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(LearnDubboApplication.class, args);

		AsyncTask asyncTask = run.getBean(AsyncTask.class);


		try {
			Future<String> doTask1 = asyncTask.doTask1();
			Future<String> doTask2 = asyncTask.doTask2();


			while (!doTask1.isDone()||!doTask2.isDone()){
				Thread.sleep(1000);
			}

			logger.info("Task1 result: {}", doTask1.get());
			logger.info("Task2 result: {}", doTask2.get());
			logger.info("All tasks finished.");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
