package main.java.com.journaldev.spring.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}

	@RequestMapping(value="/fail2login", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		model.addAttribute("logout", "true");
		return "login";

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(ModelMap model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("message", "Sorry "+username+" You don't have privileges to view this page!!!");
		return "403";
	}
}
