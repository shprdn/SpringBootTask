package com.stackroute.muzix.config;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//configuration class for h2-servlet
@EnableMongoRepositories(basePackageClasses = TrackRepository.class)
@Configuration
public class WebConfiguration {
//
//    @EventListener
//    public void onApplicationEvent(ContextRefreshedEvent event)
//    {
//        System.out.println("Using Application listener");
//    }

    @Bean
    CommandLineRunner commandLineRunner(TrackRepository trackRepository)
    {
        return String ->
        {
            trackRepository.save(new Track(1,"KKHH","Hindi"));
            trackRepository.save(new Track(2,"Despacito","Spanish"));
        };
    }
//    //bean for servletregistration
//    @Bean
//    ServletRegistrationBean h2servletRegistrationBean()
//    {
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
//        registrationBean.addUrlMappings("/console/*");
//        return registrationBean;
//    }

}
