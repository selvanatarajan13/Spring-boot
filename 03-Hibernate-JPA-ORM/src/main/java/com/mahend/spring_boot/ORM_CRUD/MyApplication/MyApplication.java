package com.mahend.spring_boot.ORM_CRUD.MyApplication;

import com.mahend.spring_boot.ORM_CRUD.MyApplication.dao.StaffDAO;
import com.mahend.spring_boot.ORM_CRUD.MyApplication.dao.studentDAO;
import com.mahend.spring_boot.ORM_CRUD.MyApplication.entity.Staff;
import com.mahend.spring_boot.ORM_CRUD.MyApplication.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(studentDAO studentDAO) {

		return runner -> {
			System.out.println("Hello Java!..");
//			createStudent(studentDAO);
//			createStaffs(StaffDAO);
//			singleObjectView(studentDAO);
//			multiObjectView(studentDAO);
			deleteSingleObject(studentDAO);

		};
	}

	private void deleteSingleObject(studentDAO studentDAO) {
		// initialize the student id
		int id = 3;

		System.out.println("Deleting the student id : "+id);
		// delete object
		studentDAO.deleteStudent(id);
	}


//	public void createStudent(studentDAO studentDAO) {
//
//		//create object
//		System.out.println("Creating new student object..");
//		Students data = new Students();
//		data.setFirstName("Abiram");
//		data.setLastName("KE");
//		data.setEmail("Abiram@gmail.com");
//
//		// save student as object
//		System.out.println("Saving student object...");
//		studentDAO.save(data);
//
//		// displayed ID of the saved student
//		System.out.println("Student object saved successfully..");
//		System.out.println("Student ID "+data.getId());
//	}
//
//	public void createStaffs(StaffDAO StaffDAO) {
//		// create object
//		System.out.println("Creating new staff object..");
//		Staff data = new Staff();
//		data.setFirstName("Jhon");
//		data.setLastName("L");
//		data.setEmail("john@gmail.com");
//
//		// save staff object
//		System.out.println("Saving staff object...");
//		StaffDAO.save(data);
//
//		// displayed the saved staff object
//		System.out.println("Staff object saved successfully..");
//		System.out.println("Staff ID "+data.getId());
//
//	}
//
//	private void singleObjectView(studentDAO studentDAO) {
//
//		int theId = 2;
//
//		// retrieve student object based on ID(primary key)
//		Students object = studentDAO.findById(theId);
//
//		// print the return object
//		System.out.println("Found the student : "+object);
//	}
//
//	private <list> void multiObjectView(studentDAO studentDAO) {
//		// retrieve student objects
//		List<Students> objects = studentDAO.findsAll();
//
//		// print the students objects
//		for (Students theStudent : objects) {
//			System.out.println(theStudent);
//		}
//	}

}
