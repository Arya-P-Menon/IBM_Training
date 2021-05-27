package com.ibm.ex9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

	@Bean("exchange")
	public ExchangeService getService() {
		System.out.println("Contacting exchange server");
		return new ExchangeService();
	}
	
}
