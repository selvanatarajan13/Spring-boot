package com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.dao;

import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.Course;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.Instructor;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.InstructorDetail;

import java.util.List;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int instructorId);

    void deleteInstructorById(Integer instructorId);

    InstructorDetail findInstructorDetailById(int instructorDetailId);

    List<Course> findCourseforInstructorById(int theId);

    Instructor findCourseforInstructorByJoinFetch(int theId);

    Instructor updateInstructorById(Instructor theInstructor);

    Course findCoureById(int theId);

    Course updateCourseById(Course theCourse);

    void deleteInstructorById(int theId);
}
