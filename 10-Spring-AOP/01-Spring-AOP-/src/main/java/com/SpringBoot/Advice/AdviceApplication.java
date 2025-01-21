package com.SpringBoot.Advice;

import com.SpringBoot.Advice.dao.AppDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AdviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			addAccount(appDao);
		};
	}

	private void addAccount(AppDao appDao) {

		appDao.addAccount();
	}

}
