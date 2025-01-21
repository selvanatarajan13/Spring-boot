package com.SpringBoot.AOP.AOPdemo;

import com.SpringBoot.AOP.AOPdemo.dao.AppDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AoPdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoPdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			System.out.println("Hello spring boot..");
			addAccount(appDao);
		};
	}

	private void addAccount(AppDao appDao) {

		appDao.addAccount();
		appDao.addBook();
	}

}
