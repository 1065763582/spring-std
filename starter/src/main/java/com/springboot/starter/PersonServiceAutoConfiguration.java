package com.springboot.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 我们日常使用的Spring官方的Starter一般采取spring-boot-starter-{name} 的命名方式，如 spring-boot-starter-web 。
 * 而非官方的Starter，官方建议 artifactId 命名应遵循{name}-spring-boot-starter 的格式。
 * @author lizq
 * @date 2019/03/16 22:06 
 */
@Configuration
// 表示将PersonProperties导入容器自动配置，也可以使用ComponentScan + component的方式导入容器
@EnableConfigurationProperties(PersonProperties.class)
// 存在PersonService的Class文件时将该类加入容器
@ConditionalOnClass(PersonService.class)
// 存在属性配置spring.person.enabled为true时加入容器，没有该配置默认为true
@ConditionalOnProperty(prefix = "spring.person", value = "enabled", matchIfMissing = true)
public class PersonServiceAutoConfiguration {

	@Autowired
	private PersonProperties properties;

	@Bean
	// 容器中不存在PersonService类型的bean时，使用此bean
	@ConditionalOnMissingBean(PersonService.class)
	public PersonService personService(){
		PersonService personService = new PersonService(properties);
		return personService;
	}

	public static void main(String[] args) {

	}
}
