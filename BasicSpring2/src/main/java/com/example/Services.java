package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Services {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Customer customer1 = (Customer)ac.getBean("cust");
		customer1.setCustId(101);
		customer1.setCustName("Alok");
		System.out.println("Customer Id - "+ customer1.getCustId()+"\n Customer Name - "+customer1.getCustName());
		Customer customer2 = (Customer)ac.getBean("cust");
		System.out.println("Customer Id - "+ customer2.getCustId()+"\n Customer Name - "+customer2.getCustName());
		
	}

}