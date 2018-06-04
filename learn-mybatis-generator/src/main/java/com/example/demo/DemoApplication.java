package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		UserMapper userMapper = context.getBean(UserMapper.class);


		List<User> users = userMapper.selectAll();
		for (User user : users) {
			System.out.println(user.toString());
		}

	}
}
