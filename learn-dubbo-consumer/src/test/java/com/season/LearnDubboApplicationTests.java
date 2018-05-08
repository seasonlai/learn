package com.season;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnDubboApplicationTests {

//	static Logger logger = LoggerFactory.getLogger(LearnDubboApplicationTests.class);
//
//	@Autowired
//	AsyncTask asyncTask;

	@Test
	public void contextLoads() {

//		try {
//			Future<String> doTask1 = asyncTask.doTask1();
//			Future<String> doTask2 = asyncTask.doTask2();
//
//
//			while (!doTask1.isDone()||!doTask2.isDone()){
//				Thread.sleep(1000);
//			}
//
//			logger.info("Task1 result: {}", doTask1.get());
//			logger.info("Task2 result: {}", doTask2.get());
//			logger.info("All tasks finished.");
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}

	}

}
