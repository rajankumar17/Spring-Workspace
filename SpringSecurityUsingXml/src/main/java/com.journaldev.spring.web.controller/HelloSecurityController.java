package main.java.com.journaldev.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HelloSecurityController {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String executeSecurity(ModelMap model, Principal principal ) {

        String name = principal.getName();
        model.addAttribute("author", name);
        model.addAttribute("message", "Welcome To Login Form Based Spring Security Example!!!");
        return "welcome";

    }
}
