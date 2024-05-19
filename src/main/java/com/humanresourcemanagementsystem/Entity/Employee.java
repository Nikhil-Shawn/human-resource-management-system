package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee implements Person {

    // Person fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID")
    private int personID;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    // Employee-specific field
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int employeeID;

    // Getters and Setters for Person fields
    @Override
    public int getPersonID() {
        return personID;
    }

    @Override
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getters and Setters for Employee-specific field
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
