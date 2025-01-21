package com.mahend.spring_boot.ORM_CRUD.MyApplication.dao;

import com.mahend.spring_boot.ORM_CRUD.MyApplication.entity.Students;

public interface studentDAO {

    // saving the object to db
    void save(Students theStudent);

    // retrieve single object from db
    <Intger> Students findById(Intger id);

    <list> list findsAll();

    void deleteStudent(Integer id);

}
