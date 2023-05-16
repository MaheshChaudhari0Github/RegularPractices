package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ap = new ClassPathXmlApplicationContext("config.xml");
		
		Product p = (Product)ap.getBean("product");
		
		p.setProductid(101);
		p.setProductname("Armour");
		
		System.out.println("\n Product No - "+p.getProductid()+"\n Product Name - "+p.getProductname());
		
		ap.registerShutdownHook();
	}
}