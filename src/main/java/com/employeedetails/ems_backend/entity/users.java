package com.employeedetails.ems_backend.entity;

import jakarta.persistence.*;


public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

}
