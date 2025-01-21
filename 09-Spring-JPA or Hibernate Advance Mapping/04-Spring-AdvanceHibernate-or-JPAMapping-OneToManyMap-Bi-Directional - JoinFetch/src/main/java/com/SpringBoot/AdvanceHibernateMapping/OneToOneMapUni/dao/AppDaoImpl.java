package com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.dao;

import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.Course;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.Instructor;
import com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager entityManager;

    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int instructorId) {
        return entityManager.find(Instructor.class, instructorId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Integer instructorId) {
        Instructor theInstructor = entityManager.find(Instructor.class, instructorId);
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int instructorDetailId) {

        InstructorDetail theInstructorDetail = entityManager.find(InstructorDetail.class, instructorDetailId);
        return theInstructorDetail;
    }

    @Override
    public List<Course> findCourseforInstructorById(int theId) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data",Course.class);
        query.setParameter("data",theId);

        List<Course> theCourses = query.getResultList();

        return theCourses;
    }

    @Override
    public Instructor findCourseforInstructorByJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " + "join fetch i.courses " + "where i.id = :data" ,Instructor.class
        );
        query.setParameter("data",theId);

        Instructor theInstructor = query.getSingleResult();
        return theInstructor;
    }

    @Override
    @Transactional
    public Instructor updateInstructorById(Instructor theInstructor) {
        Instructor instructor = entityManager.merge(theInstructor);
        return instructor;
    }

    @Override
    public Course findCoureById(int theId) {
        Course theCourse = entityManager.find(Course.class, theId);
        return theCourse;
    }

    @Override
    @Transactional
    public Course updateCourseById(Course theCourse) {
        return entityManager.merge(theCourse);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor theInstructor = entityManager.find(Instructor.class, theId);
        List<Course> courses = theInstructor.getCourses();

        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null);
        }

        entityManager.remove(theInstructor);
    }

}
