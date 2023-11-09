package io.javabrains.springbootsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/login")
    public String viewLoginPage() {
        // custom logic before showing login page...

        return "login";
    }
}
