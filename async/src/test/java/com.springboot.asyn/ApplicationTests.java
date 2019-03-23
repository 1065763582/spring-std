package com.springboot.asyn;

import java.util.concurrent.Future;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author lizq
 * @date 2019/03/23 20:10 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private Task task;

	@Test
	public void asyncTest() throws Exception {
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();
		while(true);
	}

	@Test
	// lombok注解 在需要抛出异常的地方标记，避免代码到处都是try - catch
	@SneakyThrows
	public void callbackTest() {
		Future<String> f = task.doTaskFour();
		System.out.println(f.get());
	}
}
