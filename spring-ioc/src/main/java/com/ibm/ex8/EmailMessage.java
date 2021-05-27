package com.ibm.ex8;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("email")
@Lazy
public class EmailMessage implements Message{
	
	public EmailMessage() {
		// TODO Auto-generated constructor stub
		System.out.println("Email Constructor");
	}

	@Override
	public void send(String to, String message) {
		System.out.println("Email sent to : " + to + " as " + message);
		
	}

}
