package com.springboot.starter;

import lombok.Data;
import lombok.ToString;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author lizq
 * @date 2019/03/16 22:04 
 */
@ConfigurationProperties(prefix = "spring.person")
@Data
@ToString
public class PersonProperties {
	// 姓名
	private String name;
	// 年龄
	private int age;
	// 性别
	private String sex;

}
