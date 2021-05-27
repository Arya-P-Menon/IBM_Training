package com.ibm.ex4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessageProcessor implements ApplicationContextAware {

	private ApplicationContext appCtx;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appCtx = applicationContext;
		System.out.println("Application Context Injected");
		
	}
	
	public MessageProcessor() {
		
		System.out.println("MessageProcessor Constructor");
	}
	
	public void process(String type, String to, String message) {
		Message m = appCtx.getBean(type, Message.class);
		m.send(to, message);
	}

}
