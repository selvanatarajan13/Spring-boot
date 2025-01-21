package com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni;

import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.dao.AppDao;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.Instructor;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneMapUniApplication {

	public static void main(String[] args) {

		SpringApplication.run(OneToOneMapUniApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			System.out.println("Hello Spring Boot");
			 createNewInstructor(appDao);
			// findInstructorById(appDao);
			// deleteInstructorById(appDao);
		};
	}

	// Uni directional
	private void deleteInstructorById(AppDao appDao) {

		int theId = 4;
		System.out.println("Instructor ID : " + theId);
		appDao.deleteInstructorById(theId);
		System.out.println("Instructor ID deleted successfully.");
	}

	// Uni directional
	private void findInstructorById(AppDao appDao) {

		int theId = 3;
		Instructor theInstructor = appDao.findInstructorById(theId);

		System.out.println("searching...");
		System.out.println("Instructor : " + theInstructor.getFirstName() + theInstructor.getLastName());
		System.out.println("Instructor with detail : " + theInstructor);
	}

	// Uni directional
	private void createNewInstructor(AppDao appDao) {
		Instructor theInstructor = new Instructor(
				"John","David","john@gmail.com"
		);

		InstructorDetail theInstructorDetail = new InstructorDetail(
				"www.youtube.com/@john", "food vloger"
		);

		// associate the instructor with instructor_detail
		theInstructor.setInstructorDetail(theInstructorDetail);
		System.out.println("Saving....");
		appDao.save(theInstructor);
		System.out.println("Instructor : " + theInstructor.getClass());
		System.out.println("Instructor detail : " + theInstructorDetail);
		System.out.println("Instructor with detail : " + theInstructor);
	}

}
