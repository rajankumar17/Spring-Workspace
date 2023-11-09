package com.journaldev.spring.secuity.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.journaldev.spring.secuity.config.LoginApplicationConfig;

/*

Initialize Spring MVC Application “SpringMVCWebAppInitializer” class is used to initialize “DispatcherServlet”
without web.xml file in a Annotation based configuration. SpringMVCWebAppInitializer.java

NOTE:-

When we access our application, by default SpringMVCWebAppInitializer’s getServletMappings() will allow to access root url: “/”.
We can override to forward to a different URL.
The Spring or Pivotal team is working this issue to avoid this much Java code by introduction an annotation.
Please check this at https://jira.spring.io/browse/SPR-10359.
 */

public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { LoginApplicationConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
