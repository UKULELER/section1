package com.example.config;

import com.example.web.WebConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(3);
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"*.html"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }
}


//public class WebAppInitializer extends AbstractDispatcherServletInitializer {
//
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
//        ctx.setConfigLocation("classpath:applicationContext.xml");
//        return ctx;
//    }
//
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
//        ctx.setConfigLocation("/webapp/WEB-INF/viewspace-servlet.xml");
//        return ctx;
//    }
//
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setLoadOnStartup(3);
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"*.html"};
//    }
//
//}
