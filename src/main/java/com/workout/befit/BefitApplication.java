package com.workout.befit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;




@SpringBootApplication
@EnableMongoRepositories
public class BefitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BefitApplication.class, args);
	}

}
