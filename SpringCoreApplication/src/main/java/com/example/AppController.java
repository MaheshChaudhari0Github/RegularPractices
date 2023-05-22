package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class AppController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap modelMap) {
	modelMap.addAttribute("message","Welcome to Anudip Foundation");
	return "welcome";
	}
	
	@RequestMapping(value = "/services",method = RequestMethod.GET)
	public String sayServices(ModelMap modelMap) {
	modelMap.addAttribute("message","QR Code Services");
	return "welcome";
	} 
}
