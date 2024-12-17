package com.employeedetails.ems_backend.service.impl;

import com.employeedetails.ems_backend.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Spring service bean
public class UserServiceimpl implements  UserService {

    private final EntityManager entityManager;

    @Autowired
    public UserServiceimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Object[]> getUserWithEmployeeDetails() {
        String jpql = "SELECT u.id, u.name, e.id, e.firstName, e.lastName, e.email " +
                "FROM User u " +
                "JOIN u.employee e";  // u.employee is the reference to Employee in User entity

        // Creating a typed query using the JPQL
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        // Execute the query and return the result
        return query.getResultList();
    }
}
