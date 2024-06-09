package com.humanresourcemanagementsystem.Entity;

import com.humanresourcemanagementsystem.util.DepartmentStatus;
import jakarta.persistence.*;
import java.util.Date;

@Entity
//Mapping of Department class to database table hrm_department
@Table(name = "hrm_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id" , nullable = false)
    private int departmentId;

    @Column(unique = true, nullable = false)
    private String departmentName;

    @Enumerated(EnumType.STRING)
    private DepartmentStatus departmentStatus;

    @Column(name = "createdAt", updatable = false, nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;

    @PrePersist
    // Default constructor initializes created at and updated at field with current date
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    // Getter and Setter provide access to the private fields
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public DepartmentStatus getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(DepartmentStatus departmentStatus) {
        this.departmentStatus = departmentStatus;
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

