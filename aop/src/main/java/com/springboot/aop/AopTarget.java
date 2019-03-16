package com.springboot.aop;

import org.springframework.stereotype.Component;

/**
 *
 * @author lizq
 * @date 2019/03/16 15:10 
 */
@Component
public class AopTarget {

	public void doSomething(String msg) throws Exception {
		if ("ex".equals(msg)) {
			throw new Exception("异常了");
		}
		System.out.println("doSomething :" + msg);
	}

	@MyInfoAnnotation(value = "this is my annotation")
	public void doSomething() {
		System.out.println("do Something");
	}
}
