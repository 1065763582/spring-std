package com.springboot.propertity;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitApplicationTests {

	@Autowired
	private UseProperty useProperty;

	@Test
	public void contextLoads() {
		useProperty.print();
	}

}
