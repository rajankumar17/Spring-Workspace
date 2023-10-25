package com.rajan.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@Autowired
	EmployeeDAO empDao;

	String message = "Welcome to Spring MVC!";

	@RequestMapping(value = { "/secure/hello/*","/secure/hello**" })
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}

	@RequestMapping("/status")
	public ModelAndView saveEmployee() {
		ModelAndView mv = new ModelAndView("status");
		Employee emp = new Employee();
		emp.setName(34345);
		emp.setId(34345);
		empDao.saveEmployee(emp);
		mv.addObject("message", "Employee Saved");
		return mv;
	}

	@RequestMapping("/status/all")
	public ModelAndView getEmployee() {
		ModelAndView mv = new ModelAndView("status");
		List<Employee> emp = empDao.getAllEmployees();
		mv.addObject("message", "Employee Retrieved");
		mv.addObject("employees", emp);
		return mv;

	}
	
	@RequestMapping("/logoutSuccess*")
	public ModelAndView landingPage() {
		ModelAndView mv = new ModelAndView("logoutSuccess");
		mv.addObject("message", "Landing Page");
		return mv;

	}
}
