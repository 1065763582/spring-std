package com.springboot.starter;

/**
 *
 * @author lizq
 * @date 2019/03/16 22:06 
 */
public class PersonService {
	private PersonProperties properties;

	public PersonService() {
	}

	public PersonService(PersonProperties properties) {
		this.properties = properties;
	}

	public void sayHello(){
		System.out.println(properties.toString());
	}
}
