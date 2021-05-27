package com.ibm.ex1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)//run junit inside container //no need of putting ctx in each test cases- 
							//in the former one we have to provide ctx in each test cases. thus this method is more efficient
@ContextConfiguration(locations = "classpath:ex1ctx.xml")
public class TestHello2 {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	@Qualifier("hi")
	private Hello hi;
	
	@Test
	public void testHello() {
		System.out.println("Message " + hi.getMessage());
	}
	
	@Test
	public void testHello1() {
		Hello h2 = (Hello) ctx.getBean("hi");
		System.out.println("Message " + hi.getMessage());
	}
	
	
	@Test
	public void testHello2() {
		System.out.println("Message " + hi.getMessage());
	}
	
	
	

}
