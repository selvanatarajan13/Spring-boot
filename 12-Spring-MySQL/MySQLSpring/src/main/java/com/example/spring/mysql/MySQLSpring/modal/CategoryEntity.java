package com.example.spring.mysql.MySQLSpring.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class CategoryEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "educational_levl")
    private String educationalLevel;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "university_name")
    private String universityName;
}
