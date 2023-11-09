package com.journaldev.spring.secuity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
Code Explanation:- We have defined two methods in “LoginSecurityConfig” to store and manage User Credentials and take care of Login and Logout Security features.

@EnableWebSecurity Annotation is used to enable web security in any web application.

@EnableWebMVCSecurity Annotation is used to enable web security in Spring MVC based web application.
NOTE:- @EnableWebSecurity = @EnableWebMVCSecurity + Extra features.
That’s why @EnableWebMVCSecurity Annotation is deprecated in Spring 4.x Framework.4. “LoginSecurityConfig”
class or any class which is designated to configure Spring Security, should extend “WebSecurityConfigurerAdapter” class or implement related interface.

configureGlobal() method is used to store and mange User Credentials.
In configureGlobal() method, we can use authorities() method to define our application Roles like “ROLE_USER”. We can also use roles() method for same purpose.

Difference between authorities() and roles() methods:
authorities() needs a complete role name like “ROLE_USER” roles() needs a role name like “USER”.
It will automatically add “ROLE_” value to this “USER” role name.
NOTE:- We will develop another example to demonstrate Roles like “USER”,“ADMIN” in my coming posts.

Important method to take care of Login and Logout Security is configure(HttpSecurity http)
The following code snipped is used to avoid unauthorized access to “/homePage”. If you try to access this page directly,
we will redirected to “/loginPage” page automatically.
.antMatchers("/homePage").access("hasRole('ROLE_USER')")
If we remove access(“hasRole(‘ROLE_USER’)”) method call, then we can access this page without login to our application.13.
We have configured login and logout features using formLogin() and logout() methods.
 */


@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .withUser("journaldev")
                .password("jd@123")
                .authorities("ROLE_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/homePage").access("hasRole('ROLE_USER')")
                .and()
                .formLogin().loginPage("/loginPage")
                .defaultSuccessUrl("/homePage")
                .failureUrl("/loginPage?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/loginPage?logout");

    }
}