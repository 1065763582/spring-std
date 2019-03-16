package com.springboot.propertity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizq
 * @date 2019/03/15 21:57 
 */
@Component
public class UseProperty {
	@Autowired
	private MyProperty myProperty;

	public void print(){
		System.out.println(myProperty.toString());
	}
}
