package com.virtusa.SkyScanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/** 
 * Airline Reservation System for booking flight tickets
  */
@SpringBootApplication
//@EnableSwagger2
public class AirlineReservationSystem {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationSystem.class, args);
	}
	
}

