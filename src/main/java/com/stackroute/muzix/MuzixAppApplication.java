package com.stackroute.muzix;

import com.stackroute.muzix.domain.Track;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class MuzixAppApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		logger.info("Applicaton started using command line runner");
	}

	protected final Log logger = LogFactory.getLog(getClass());
	//muzixApp having main method
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(MuzixAppApplication.class, args);

	}



}


