package com.ibm.ex8;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMessage {

	@Test
	public void testMessage() {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		MessageProcessor proc = appCtx.getBean(MessageProcessor.class);
		
		proc.process("sms", "9876543210", "Hi");
		proc.process("email", "arya@gmail.com", "Hello");
	}
}
