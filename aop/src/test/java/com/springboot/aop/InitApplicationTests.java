package com.springboot.aop;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitApplicationTests {

	@Autowired
	private AopTarget aopTarget;

	@Test
	public void contextLoads() throws Exception {
		aopTarget.doSomething("study aop");
	}

	/**
	 *  若Around把异常吃了，则AfterThrowing将无效
	 *  被AfterThrowing增加后将不会执行around after和AfterReturning的增强
	 * @throws Exception
	 */
	@Test
	public void aopExceptionTest() throws Exception {
		try {
			aopTarget.doSomething("ex");
		}
		catch (Exception e) {
			System.out.println("end");
		}
	}

	@Test
	public void annotationTest(){
		aopTarget.doSomething();
	}
}
