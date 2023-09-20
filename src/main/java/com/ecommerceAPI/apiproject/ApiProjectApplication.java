package com.ecommerceAPI.apiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ApiProjectApplication {

	private static final Logger logger = LoggerFactory.getLogger(ApiProjectApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ApiProjectApplication.class, args);
		logger.info("Application started");
		logger.info("This is an informational message.");
		logger.error("This is an error message.");
		logger.warn("This is a warning message.");
		logger.info("Application ended");
	}

}
