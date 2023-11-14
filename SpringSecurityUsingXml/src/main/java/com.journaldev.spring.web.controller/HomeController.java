package main.java.com.journaldev.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	@RequestMapping("/city")
	public String city(){
		return "city";
	}
}
