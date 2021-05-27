package com.ibm.ex6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Stock {

	public Stock() {
		System.out.println("Default Constructor");
	}
	
	private static Stock stock;
	
	@Bean("stk")
	public static Stock get() {
		System.out.println("Stock Singleton");
		if(stock==null)
			stock =  new Stock();
		return stock;
	}
	
}
