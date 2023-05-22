package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ApplicationController {
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap modelMap) {
		modelMap.addAttribute("message", "WELCOME TO ANUDIP FOUNDATION");
		return "welcome";
	}
	@RequestMapping(value= "/service",method = RequestMethod.GET)
	public String sayService(ModelMap modelMap) {
		modelMap.addAttribute("message", "ANDP Services");
		return "welcome";
	}
	@RequestMapping(value= "/address",method = RequestMethod.GET)
	public String sayaddress(ModelMap modelMap) {
		modelMap.addAttribute("msg", "Pune Mall");
		return "home";
	}
}
