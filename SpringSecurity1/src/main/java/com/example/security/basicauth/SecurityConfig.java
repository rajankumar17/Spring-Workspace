package com.example.security.basicauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//we can configure a utility class WebSecurityConfigurerAdapter.
// It helps in requiring the user to be authenticated prior to accessing any configured URL (or all urls) within our application.

/*
The general format for a password is:

{id}encodedPassword
where: "id" is an identifier used to look up which PasswordEncoder should be used.
"encodedPassword" is the original encoded password for the selected PasswordEncoder.
Most commonly used PasswordEncoders with their id’s are:
"noop" which uses plain text NoOpPasswordEncoder
"bcrypt" which uses `BCryptPasswordEncoder'
"scrypt" which uses SCryptPasswordEncoder
"pbkdf2" which uses 'Pbkdf2PasswordEncoder'
"sha256" which uses StandardPasswordEncoder

Example of a Password that is encoded using bcrypt is:
{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .antMatcher("/employees/**")
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    //Here username = admin , password=password
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}password")     //password storage format, which is {noop} for plain text passwords
                .roles("USER");
    }

}
