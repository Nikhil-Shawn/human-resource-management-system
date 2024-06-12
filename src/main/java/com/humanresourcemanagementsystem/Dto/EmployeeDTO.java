package com.humanresourcemanagementsystem.Dto;

import com.humanresourcemanagementsystem.Entity.Department;
import com.humanresourcemanagementsystem.Entity.Education;
import com.humanresourcemanagementsystem.Entity.Experience;
import com.humanresourcemanagementsystem.Entity.Person;

import java.util.Date;

public class EmployeeDTO extends PersonDTO {

    // Employee entity fields
    private int employeeID;
    private Person person;
    private Department departmentId;
    private Experience experience;
    private Education education;
    private int supervisorId;
    private Boolean isSupervisor;
    private String manageWhom;
    private String employmentType;
    private Boolean isAdmin;
    private String empEmail;
    private String empPassword;
    private String designation;
    private Date hireDate;
    private Date terminationDate;
    private String employmentStatus;
    private String workLocation;
    private Date createdAt;
    private Date updatedAt;

    // Default constructor initializes created at and updated at field with current date
    public EmployeeDTO() {}

    //Parameterized constructor initializes all fields with provided values
    public EmployeeDTO(int employeeID, Boolean isSupervisor, String manageWhom, String employmentType, Boolean isAdmin, String empEmail, String empPassword, String designation, Date hireDate, Date terminationDate, String employmentStatus, String workLocation, Date createdAt, Date updatedAt) {
        this.employeeID = employeeID;
        this.isSupervisor = isSupervisor;
        this.manageWhom = manageWhom;
        this.employmentType = employmentType;
        this.isAdmin = isAdmin;
        this.empEmail = empEmail;
        this.empPassword = empPassword;
        this.designation = designation;
        this.hireDate = hireDate;
        this.terminationDate = terminationDate;
        this.employmentStatus = employmentStatus;
        this.workLocation = workLocation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter and Setter provide access to the private fields
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

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Boolean getSupervisor() {
        return isSupervisor;
    }

    public void setSupervisor(Boolean supervisor) {
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
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

    //Provides detailed and formatted information about the object’s current state.
    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeID=" + employeeID +
                ", person=" + person +
                ", department=" + departmentId +
                ", experience=" + experience +
                ", education=" + education +
                ", supervisorId=" + supervisorId +
                ", isSupervisor=" + isSupervisor +
                ", manageWhom='" + manageWhom + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", isAdmin=" + isAdmin +
                ", empEmail='" + empEmail + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", designation='" + designation + '\'' +
                ", hireDate=" + hireDate +
                ", terminationDate=" + terminationDate +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

