package com.SpringBoot.AdvanceHibernateMapping.OneToOneMapUni.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "")
    private String comment;
}
