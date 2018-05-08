package com.season;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnDubboServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(LearnDubboServerApplication.class, args);

	}
}
