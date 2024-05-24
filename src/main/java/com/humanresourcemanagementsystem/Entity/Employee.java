package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmployeeID")
    private int employeeID;

    @ManyToOne
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID")
    private Person person;


    // Constructors
    public Employee() {}

    public Employee(Person person) {
        this.person = person;
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
