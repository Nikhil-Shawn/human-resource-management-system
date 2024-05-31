package com.humanresourcemanagementsystem.Dto;

import com.humanresourcemanagementsystem.Entity.Person;

import java.util.Date;

public class EmployeeDTO extends PersonDTO {

    private int employeeID;
    private String designation;
    private Person person;

    public EmployeeDTO(){
    }

    public EmployeeDTO(String firstName, String lastName, String address, String email, String password, String phone, Date dateOfBirth, String gender, String nationality, String maritalStatus, String personType, int employeeID, String designation) {
        super(firstName,lastName,address, email, password, phone, dateOfBirth, gender, nationality, maritalStatus, personType);
        this.employeeID = employeeID;
        this.designation = designation;
    }

    public EmployeeDTO(int employeeID) {
    }

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

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeID=" + employeeID +
                "personID=" + getPersonID() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", gender='" + getGender() + '\'' +
                ", nationality='" + getNationality() + '\'' +
                ", maritalStatus='" + getMaritalStatus() + '\'' +
                ", personType='" + getPersonType() + '\'' +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                '}';
    }
}
