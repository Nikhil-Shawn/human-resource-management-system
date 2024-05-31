package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hrm_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int employeeID;

    @Column(name = "Designation")
    private String designation;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Asset asset;

    // Constructors
    public Employee() {}

    public Employee(Person person, String designation) {
        this.person = person;
        this.designation = designation;
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
