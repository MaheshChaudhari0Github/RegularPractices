package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		Employee employee = (Employee)ac.getBean("emp");
		System.out.println("Employee No - "+employee.getEmpId()+"\n Employee Name - "+employee.getEmpName());
	}

}