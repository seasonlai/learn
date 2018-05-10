package com.season;

import com.season.jms.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class LearnDubboServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(LearnDubboServerApplication.class, args);

//		Consumer consumer = run.getBean(Consumer.class);



	}
}
