package com.springboot.propertity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizq
 * @date 2019/03/15 21:51 
 */

// PropertySource的目的是导入properties文件
@PropertySource(value = "my-property.properties", encoding = "utf-8")
// ConfigurationProperties的目的是使用前缀为person的属性值，赋值给该类
@ConfigurationProperties(prefix = "person")
@Component
@Data
@ToString
public class MyProperty {
	private String name;
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
}
