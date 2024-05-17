package Entity;

import java.util.Date;

public class Employee implements Person {
    // Person fields
    private int personID;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String maritalStatus;
    private String personType;

    // Employee-specific fields
    private int employeeID;
    private int departmentID;
    private int workExperienceID;
    private int educationDetailID;
    private int assetID;
    private int supervisorID;
    private boolean isSupervisor;
    private String manageWhom;
    private String employmentType;
    private String designation;
    private Date hireDate;
    private Date terminationDate;
    private String employmentStatus;
    private String workLocation;

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

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    @Override
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String getMaritalStatus() {
        return maritalStatus;
    }

    @Override
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String getPersonType() {
        return personType;
    }

    @Override
    public void setPersonType(String personType) {
        this.personType = personType;
    }

    // Getters and Setters for Employee-specific fields
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getWorkExperienceID() {
        return workExperienceID;
    }

    public void setWorkExperienceID(int workExperienceID) {
        this.workExperienceID = workExperienceID;
    }

    public int getEducationDetailID() {
        return educationDetailID;
    }

    public void setEducationDetailID(int educationDetailID) {
        this.educationDetailID = educationDetailID;
    }

    public int getAssetID() {
        return assetID;
    }

    public void setAssetID(int assetID) {
        this.assetID = assetID;
    }

    public int getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(int supervisorID) {
        this.supervisorID = supervisorID;
    }

    public boolean isSupervisor() {
        return isSupervisor;
    }

    public void setSupervisor(boolean supervisor) {
        isSupervisor = supervisor;
    }

    public String getManageWhom() {
        return manageWhom;
    }

    public void setManageWhom(String manageWhom) {
        this.manageWhom = manageWhom;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
}

