package com.springboot.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InitApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(InitApplication.class);
		//需要把监听器加入到spring容器中
		application.addListeners(new MyApplicationListener());
		ConfigurableApplicationContext context =  application.run(args);
		//发布事件
		context.publishEvent(new MyEvent("this is event args that type is Object"));
		context.close();
	}
}
