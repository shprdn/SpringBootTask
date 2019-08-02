package com.stackroute.muzix;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.service.TrackService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class MuzixAppApplication{// implements CommandLineRunner {

//	TrackService trackService;
//	@Autowired
//	public void setTrackService(TrackService trackService) {
//		this.trackService = trackService;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		//seed data to pre-fill the database with track
//		//information whenever the application starts
//		trackService.saveTrack(new Track(20,"main hoon hero tera","Armaan Malik"));
//		trackService.saveTrack(new Track(21,"suraj dooba hai","Amaal Malik"));
//		logger.info("Applicaton started using command line runner");
//	}
//
//	protected final Log logger = LogFactory.getLog(getClass());
//	//muzixApp having main method
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(MuzixAppApplication.class, args);

	}



}


