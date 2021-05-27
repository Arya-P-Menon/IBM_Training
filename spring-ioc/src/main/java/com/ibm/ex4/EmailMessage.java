package com.ibm.ex4;

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
