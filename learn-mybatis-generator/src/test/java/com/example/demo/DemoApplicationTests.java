package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	public void contextLoads() {

		Assert.notNull(userMapper,"为空，擦");

		List<User> users = userMapper.selectAll();
		for (User user : users) {
			System.out.println(user.toString());
		}
	}

}
