package com.journaldev.spring.secuity.config.core;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*
Initialize Spring Security

“SpringSecurityInitializer” is used to register the DelegatingFilterProxy to use the springSecurityFilterChain.
It avoids writing Filters configuration in web.xml file.
 */

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}