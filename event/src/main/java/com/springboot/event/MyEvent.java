package com.springboot.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author lizq
 * @date 2019/03/16 18:14 
 */
public class MyEvent extends ApplicationEvent
{

	/**
	 * Create a new ApplicationEvent.
	 * @param source 事件发生时的对象，通过此对象将参数传递给事件的监听者
	 */
	public MyEvent(Object source) {
		super(source);
	}
}
