package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("config.xml");
		Customer customer = (Customer) ap.getBean("cust");
		List custList = new ArrayList();
		custList.add("Alok");
		custList.add("Balu");
		custList.add("Kalu");
		custList.add("Ramu");
		custList.add("Shamu");
		custList.add("Alok");
		customer.setCustList(custList);
		
		Set custSet = new HashSet();
		custSet.add("Alok");
		custSet.add("Balu");
		custSet.add("Kalu");
		custSet.add("Ramu");
		custSet.add("Shamu");
		custSet.add("Alok");
		
		customer.setCustSet(custSet);
		
		Map custMap = new HashMap();
		custMap.put("Id", "121");
		custMap.put("Address", "PCMC");
		custMap.put("Salary", "100");
		custMap.put("Name", "KALURAMJI");
		customer.setCustMap(custMap);
		
		Properties custProperties = new Properties();
		custProperties.put("Id", "121");
		custProperties.put("Address", "PCMC");
		custProperties.put("Salary", "100");
		custProperties.put("Name", "KALURAMJI");
		customer.setCustProperties(custProperties);
		
		System.out.println(customer.getCustList());
		System.out.println(customer.getCustSet());
		System.out.println(customer.getCustMap());
		System.out.println(customer.getCustProperties());
	}
}