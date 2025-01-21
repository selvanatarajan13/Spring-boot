package com.SpringBoot.RestService.DAOandService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaOandServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DaOandServiceApplication.class, args);
	}

	public CommandLineRunner commandLineRunner() {
		return runner -> {
			System.out.println("Hello");
		};
	}

}
