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
			// Uni Directional

			// createNewInstructor(appDao);
			// findInstructorById(appDao);
			// deleteInstructorById(appDao);

			// Bi-Directional

			findInstructorDetailById(appDao);
			// deleteInstructorDetailById(appDao);

			// it will delete only the instructor detail and keep the instructor
			// deleteInstructorDetailByIdOnly(appDao);
		};
	}

	// Bi-Directional delete only InstructorDetail
	private void deleteInstructorDetailByIdOnly(AppDao appDao) {
		int theId = 7;

		System.out.println("Id : " + theId);
		appDao.deleteInstructorDetailByIdOnly(theId);
		System.out.println("Id : " + theId + " Instrcutor detail deleted sucessfully");
	}

	// Bi-directional delete method
	private void deleteInstructorDetailById(AppDao appDao) {

		int theId = 3;
		System.out.println("InstrcutorDetail Id : " + theId);
		appDao.deleteInstructorDetailById(theId);
		System.out.println("Instructor with Detail Id Deleted successfully");
	}

	// Bi-Directional Mapping
	private void findInstructorDetailById(AppDao appDao) {

		int theId = 1;

		InstructorDetail theInstructorDetail = appDao.findInstructorDetailById(theId);

		System.out.println("Bi-Directional");
		System.out.println("Instructor Detail : " + theInstructorDetail);
		System.out.println("Instructor with detail : " + theInstructorDetail.getInstructor());
	}

	// Uni directional
	private void deleteInstructorById(AppDao appDao) {
		int theId = 5;
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
