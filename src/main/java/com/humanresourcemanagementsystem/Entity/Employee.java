package com.humanresourcemanagementsystem.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "hrm_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeID;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "experience_id", referencedColumnName = "experience_id")
    private Experience experience;

    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "supervisor_id", referencedColumnName = "employee_id")
    private Employee supervisor;

    @Column(name = "is_supervisor")
    private Boolean isSupervisor;

    @Column(name = "manage_whom")
    private String manageWhom;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "emp_email", unique = true, nullable = false)
    private String empEmail;

    @Column(name = "emp_password")
    private String empPassword;

    @Column(name = "designation")
    private String designation;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "termination_date")
    private Date terminationDate;

    @Column(name = "employment_status")
    private String employmentStatus;

    @Column(name = "work_location")
    private String workLocation;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public Boolean getIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(Boolean IsSupervisor) {
        isSupervisor = IsSupervisor;
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
}
