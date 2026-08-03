package com.ny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String login() {
		//System.out.println("!");
		return "redirect:/Login";
	}
}
