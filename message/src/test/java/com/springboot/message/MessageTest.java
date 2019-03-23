package com.springboot.message;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

@RunWith(Parameterized.class)
@SpringBootTest
@ContextConfiguration
public class MessageTest {

	private Locale locale ;

	private TestContextManager testContextManager;

	public MessageTest(Locale local) {
		this.locale = local;
	}

	@Autowired
	private MessageSource messageSource;

	@Before
	public void setUp() throws Exception {
		testContextManager = new TestContextManager(getClass());
		testContextManager.prepareTestInstance(this);
	}

	@Parameters
	public static Collection prepareData() {
		Object[] objs = new Object[]{Locale.SIMPLIFIED_CHINESE,Locale.US,Locale.TRADITIONAL_CHINESE};
		return Arrays.asList(objs);
	}

	@Test
	public void titleTest() {
		String out = messageSource.getMessage("welcome", null, locale);
		System.out.println(out);
	}
}