package com.poc6.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MainApp {
public static void main(String[] args) {
	 final Logger logger = LoggerFactory.getLogger(MainApp.class);
	SpringApplication.run(MainApp.class);
	logger.info("Main Application has Started");
}
}
