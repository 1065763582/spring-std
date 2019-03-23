package com.springboot.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author lizq
 * @date 2019/03/16 22:13 
 */
@SpringBootApplication
@EnableScheduling
public class InitApplication {
	public static void main(String[] args) {
		SpringApplication.run(InitApplication.class);
	}
}
