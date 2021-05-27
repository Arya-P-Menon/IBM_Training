package com.ibm.ex3;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.ex2.Stock;

public class TestMyLife {
	
	@Test
	public void testMyLife() {
		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("ex3ctx.xml");
		MyLife life = (MyLife) appCtx.getBean(MyLife.class);
		
		appCtx.close();//destory will be called only if it is closed
	}

}
