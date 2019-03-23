package com.springboot.asyn;

/**
 *
 * @author lizq
 * @date 2019/03/23 20:09 
 */

import java.util.Random;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class Task {

	private static final Logger log = LoggerFactory.getLogger(Task.class);

	public static Random random =new Random();

	@Async("taskExecutor")
	public void doTaskOne() throws Exception {
		log.info("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(3000));
		long end = System.currentTimeMillis();
		log.info("完成任务一，耗时：" + (end - start) + "毫秒");
	}

	@Async("taskExecutor")
	public void doTaskTwo() throws Exception {
		log.info("开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(3000));
		long end = System.currentTimeMillis();
		log.info("完成任务二，耗时：" + (end - start) + "毫秒");
	}

	@Async("taskExecutor")
	public void doTaskThree() throws Exception {
		log.info("开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(3000));
		long end = System.currentTimeMillis();
		log.info("完成任务三，耗时：" + (end - start) + "毫秒");
	}

	@Async("taskExecutor")
	public Future<String> doTaskFour() throws Exception {
		log.info("开始做任务四");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		log.info("完成任务四，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务四完成");
	}
}
