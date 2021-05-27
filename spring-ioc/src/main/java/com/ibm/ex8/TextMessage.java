package com.ibm.ex8;

import org.springframework.stereotype.Component;

@Component("sms")
public class TextMessage implements Message{
	
	public TextMessage() {
		// TODO Auto-generated constructor stub
		System.out.println("Text Message Constructor");
	}

	@Override
	public void send(String to, String message) {
		System.out.println("SMS sent to : " + to + " as " + message);
		
	}

}
