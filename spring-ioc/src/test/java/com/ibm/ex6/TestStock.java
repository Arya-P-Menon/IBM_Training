package com.ibm.ex6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestStock {

	@Test
	public void testStock() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		Stock stock1 = (Stock) appCtx.getBean("stk");
		Stock stock2 = (Stock) appCtx.getBean("stk");
		System.out.println(stock1==stock2);
	}
}
