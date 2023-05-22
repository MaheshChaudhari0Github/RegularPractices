package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee employee = (Employee) applicationContext.getBean("emp");
		employee.setEmpId(101);
		employee.setEmpName("Alok");
		System.out.println("Employee Id : " + employee.getEmpId() + " Employee Name : " + employee.getEmpName());
	}
}
