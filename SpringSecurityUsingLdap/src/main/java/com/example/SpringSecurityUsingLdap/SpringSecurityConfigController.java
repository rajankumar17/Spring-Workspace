package com.example.SpringSecurityUsingLdap;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
We have extended the predefined class that is WebSecurityConfigurerAdapter, which internally implements the interface WebSecurityConfigurer.
It provides us the flexibility to configure our own spring security rule.
So, we have to override two methods and provide our own logic or rules for security as you can see in the above code.
 */
@EnableWebSecurity
//@EnableLdapRepositories(basePackages = "com.example.SpringSecurityUsingLdap.*")
public class SpringSecurityConfigController extends WebSecurityConfigurerAdapter {

    /*
    This method is used to tell the spring security to authenticate with LDAP Server data.

    Let’s understand in the detail what each line of the code is doing.

    auth.ldapAuthentication(): Here we are specifying the type of authentication we required so, we choose LDAP authentication.

    .userDnPatterns(“uid={0},ou=people”): Basically Dn stands for distinguish the name, which is used to show the way in which users’
    information has been stored in the LDAP Server. uid is the user id of the people present in the LDAP Server.

    You can see in the .ldif file we have users information stored in following pattern.
    .groupSearchBase(“ou=groups”): It will tell the spring security to start the search from users’ information from root directory groups in the LDAP Server.

    .url(“ldap://localhost:8389/dc=springframework,dc=org”): URL where LDAP Server is running, and the root folder is “org”.

    .passwordEncoder(new BCryptPasswordEncoder()): Password encoded in the Bycrpt format.

    .passwordAttribute(“userPassword”): It represents the parameter in which the password has stored in the .ldif file in the LDAP server.
    If you see in the .ldif file the attribute or variable name in which the password has stored is userPassword: $2a$10$c6bSeWPhg06xB1lvmaWNNe4NROmZiSpYhlocU/98HNr2MhIOiSt36
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups").contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and().passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("userPassword");
    }

    /*
    This method ensures that any HTTP Request must be fully authenticated before accessing our endpoints and if it is not authenticated,
    then it will redirect to the login page.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().permitAll();
    }

}
