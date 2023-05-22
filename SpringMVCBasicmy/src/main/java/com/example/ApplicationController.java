package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ApplicationController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap map) {
		map.addAttribute("message", "WELCOME TO ANUDIP");
		return "welcome";
	}

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public String sayServices(ModelMap map) {
		map.addAttribute("message", "Software Development");
		return "welcome";
	}

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String sayAddress(ModelMap map) {
		map.addAttribute("message", "Akurdi, Pune");
		return "welcome";
	}
}