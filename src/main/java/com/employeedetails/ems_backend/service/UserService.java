package com.employeedetails.ems_backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    @Autowired
   public EntityManager entityManager = null;

    public default List<Object[]> getUserWithEmployeeDetails() {
        String jpql = "SELECT u.id, u.name, e.id, e.firstName, e.lastName, e.email " +
                "FROM User u " +
                "JOIN u.employee e";  // u.employee is the reference to Employee in User entity

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        // Execute the query
        List<Object[]> result = query.getResultList();

        // Return the result
        return result;
    }
}
