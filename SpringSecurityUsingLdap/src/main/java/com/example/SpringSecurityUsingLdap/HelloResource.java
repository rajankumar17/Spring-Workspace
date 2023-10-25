package com.example.SpringSecurityUsingLdap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
