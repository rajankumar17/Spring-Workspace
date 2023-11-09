package com.journaldev.spring.secuity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
Code Explanation:- We use “LoginApplicationConfig” class to define Spring MVC View Resolvers to avoid writing “web.xml” file.

@EnableWebMvc Annotation is used to enable Spring Web MVC Application Features in Spring Framework
@Import Annotation is used to import Spring Security Configuration class into this class.
@ComponentScan Annotation is used to do component scanning in the specified package. It is equal to “context:component-scan” in Spring XML Configuration.
 */
@EnableWebMvc
@Configuration
@ComponentScan({ "com.journaldev.spring.*" })
@Import(value = { LoginSecurityConfig.class })
public class LoginApplicationConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}