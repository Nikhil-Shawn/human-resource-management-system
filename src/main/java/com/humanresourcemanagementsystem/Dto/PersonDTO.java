package com.humanresourcemanagementsystem.Dto;

import java.util.Date;

public class PersonDTO {

    // Person entity fields
    private int personID;
    private String firstName;
    private String lastName;
    private String address;
    private String personEmail;
    private String personPassword;
    private String phone;
    private Date dateOfBirth;
    private String gender;
    private String nationality;
    private String maritalStatus;
    private String personType;
    private Date createdAt;
    private Date updatedAt;

    // Default constructor initializes created at and updated at field with current date
    public PersonDTO() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    //Parameterized constructor initializes all fields with provided values
    public PersonDTO(String firstName, String lastName, String address, String email, String password, String phone, Date dateOfBirth, String gender, String nationality, String maritalStatus, String personType) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.personEmail = email;
        this.personPassword = password;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.personType = personType;
    }

    // Getter and Setter provide access to the private fields
    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    //Provides detailed and formatted information about the object’s current state.
    @Override
    public String toString() {
        return "PersonDTO{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", personEmail='" + personEmail + '\'' +
                ", personPassword='" + personPassword + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", personType='" + personType + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
