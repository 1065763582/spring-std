package com.springboot.init;

import com.springboot.starter.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author lizq
 * @date 2019/03/16 22:19 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTests {
	@Autowired
	private PersonService personService;

	@Test
	public void contextLoads() throws Exception {
		personService.sayHello();
	}
}