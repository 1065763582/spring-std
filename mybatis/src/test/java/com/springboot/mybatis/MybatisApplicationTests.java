package com.springboot.mybatis;

import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void selectTest() {
		userMapper.selectByPrimaryKey(1);
	}
	@Test
	@Transactional
	public void insertTest(){
		User u = new User();
		u.setId(new Random().nextInt(10000000));
		u.setName("testt123");
		u.setBirth(new Date());
		userMapper.insert(u);
		User u2 = new User();
		u2.setId(new Random().nextInt(10000000));
		u2.setName("testt123");
		u2.setBirth(new Date());
		userMapper.insert(u2);
	}

}
