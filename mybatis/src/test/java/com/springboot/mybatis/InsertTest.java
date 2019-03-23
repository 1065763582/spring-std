package com.springboot.mybatis;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

@RunWith(Parameterized.class)
@SpringBootTest
@ContextConfiguration
public class InsertTest {

	private static final int COUNT = 10;

	private User user;

	private TestContextManager testContextManager;

	public InsertTest(User user) {
		this.user = user;
	}

	@Autowired
	private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
		testContextManager = new TestContextManager(getClass());
		testContextManager.prepareTestInstance(this);
	}

	@Parameters
	public static Collection prepareData() {
		Object[] users = new Object[COUNT];
		for (int i = 0; i < COUNT; i++) {
			User u = new User();
			u.setId(new Random().nextInt(10000000));
			u.setName("lzq");
			u.setBirth(new Date());
			users[i] = u;
		}
		return Arrays.asList(users);
	}

	@Test
	public void insertTest() {
		userMapper.insert(user);
	}
}