package com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni;

import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.dao.AppDao;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.Course;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.Instructor;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OneToOneMapUniApplication {

	public static void main(String[] args) {

		SpringApplication.run(OneToOneMapUniApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			System.out.println("Hello Spring..");
			// findInstructorById(appDao);
			// findInstructorDetailById(appDao);

			// createInstructorwithCourse(appDao);
			findCourseforInstructorById(appDao);
		};
	}

	private void findCourseforInstructorById(AppDao appDao) {

		int theId = 1;

		Instructor theInstructor = appDao.findInstructorById(theId);

		List<Course> theCourses = appDao.findCourseforInstructorById(theId);

		theInstructor.setCourses(theCourses);

		System.out.println("the instructor Id : " + theId);
		System.out.println("Instructor : " + theInstructor);
		System.out.println("Instructor Courses : " + theInstructor.getCourses());
	}

	private void findInstructorDetailById(AppDao appDao) {

        int theId = 1;

        InstructorDetail theInstructorDetail = appDao.findInstructorDetailById(theId);

        System.out.println("Instructor Id : " + theId);
        System.out.println("Searching...");
        System.out.println("Instructor : " + theInstructorDetail);
        System.out.println("Instructor : " + theInstructorDetail.getInstructor());
    }

    private void findInstructorById(AppDao appDao) {

        int theId = 1;
        Instructor theInstructor = appDao.findInstructorById(theId);

        System.out.println("Instructor Id : " + theId);
        System.out.println("Searching...");
        System.out.println("Instructor : " + theInstructor);
    }

    private void createInstructorwithCourse(AppDao appDao) {

		Instructor theInstructor = new Instructor(
				"Bala","Chandra","bala@gmail.com"
		);

		InstructorDetail theInstructorDetail = new InstructorDetail(
				"www.youtube.com/@Balachandra_in","Tutor"
		);

		theInstructor.setInstructorDetail(theInstructorDetail);

		Course theCourse = new Course("Full Stack Development");

		Course theCourse2 = new Course("Financil Advice");

		theInstructor.add(theCourse);
		theInstructor.add(theCourse2);

		System.out.println("Saving....");
		appDao.save(theInstructor);
		System.out.println("Instructor : " + theInstructor );
	}


}
