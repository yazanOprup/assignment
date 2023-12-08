package com.progresssoft.progresssoftassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProgressSoftAssignmentApplication {
	private static final Logger logger = LoggerFactory.getLogger(ProgressSoftAssignmentApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(ProgressSoftAssignmentApplication.class, args);
			logger.info("Application just started.....");

		} catch (Exception er) {
			System.out.println("Exception Occurred: " + er.getMessage());
		}

	}
}
