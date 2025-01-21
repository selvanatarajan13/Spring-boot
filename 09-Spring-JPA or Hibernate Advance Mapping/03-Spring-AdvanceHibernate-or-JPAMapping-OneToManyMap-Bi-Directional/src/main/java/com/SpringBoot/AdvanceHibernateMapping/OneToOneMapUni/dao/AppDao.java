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
}
