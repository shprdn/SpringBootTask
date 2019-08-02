package com.stackroute.muzix.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

//configuration class for h2-servlet
@Configuration
public class WebConfiguration {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        System.out.println("Using Application listener");
    }

    //bean for servletregistration
    @Bean
    ServletRegistrationBean h2servletRegistrationBean()
    {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

}
