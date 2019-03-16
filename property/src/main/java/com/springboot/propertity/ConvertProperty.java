package com.springboot.propertity;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

/**
 *
 * @author lizq
 * @date 2019/03/16 13:35 
 */
@Configuration
public class ConvertProperty {
	@Bean
	public ConversionService conversionService() {
		FormattingConversionServiceFactoryBean factory = new FormattingConversionServiceFactoryBean();
		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
		registrar.setUseIsoFormat(true);
		factory.setFormatterRegistrars(Collections.singleton(registrar));
		factory.afterPropertiesSet();
		return factory.getObject();
	}
}
