package com.ibm.ex9;

import java.lang.annotation.Annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestExchange {
	
	@Test
	public void testConfig() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ExchangeConfig.class);
		
		ExchangeService es = (ExchangeService) appCtx.getBean("exchange");
		es.convert();
	}

}
