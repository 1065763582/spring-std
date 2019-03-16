package com.springboot.event;

import org.springframework.context.ApplicationListener;

/**
 *
 * @author lizq
 * @date 2019/03/16 18:16 
 */
public class MyApplicationListener implements ApplicationListener<MyEvent> {
	@Override
	public void onApplicationEvent(MyEvent event) {
		Object param = event.getSource();
		System.out.println(param);
	}
}
