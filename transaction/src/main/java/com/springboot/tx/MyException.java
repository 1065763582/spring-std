package com.springboot.tx;

/**  
 * 
 * @Title MyException.java   
 * @Package com.springboot.tx   
 * @Description TODO(用一句话描述该文件做什么)   
 * @author lizhiqiang     
 * @date Jul 18, 2020 11:31:13 AM
 * 
 */
public class MyException extends RuntimeException {

	public MyException() {
		super("测试异常");
	}
	
	public MyException(String message) {
		super(message);
	}
}
