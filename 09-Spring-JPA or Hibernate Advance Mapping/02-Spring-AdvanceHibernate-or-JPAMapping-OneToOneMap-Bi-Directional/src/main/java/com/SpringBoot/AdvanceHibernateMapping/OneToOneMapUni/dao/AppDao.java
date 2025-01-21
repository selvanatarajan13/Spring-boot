package com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.dao;

import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.Instructor;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int instructorId);

    void deleteInstructorById(Integer instructorId);

    // Bi - directional

    InstructorDetail findInstructorDetailById(int instructorDetailId);

    void deleteInstructorDetailById(Integer instructorDetailId);

    void deleteInstructorDetailByIdOnly(Integer instructionDetailId);
}
