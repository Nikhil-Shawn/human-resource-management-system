package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//Mapping of Separation class to database table hrm_separation
@Table(name = "hrm_separation")
public class Separation {

    //Separation id is a primary key and is autogenerated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "separation_id")
    private int separation_id;

    //One Employee can have one separation
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @Column(name = "employee_department", nullable = false)
    private String employee_department;

    @Column(name = "separation_date")
    private Date separate_date;

    @Column(name = "separation_type", nullable = false , unique = true)
    private String separation_type;

    @Column(name = "separation_reason", nullable = false , unique = true)
    private String separation_reason;

    @Column(name = "settlement", nullable = false , unique = true)
    private String settlement;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    // Default constructor initializes created at and updated at field with current date
    public Separation() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    //Parameterized constructor initializes all fields with provided values

    public Separation(int separation_id, Employee employee, String employee_department, Date separate_date, String separation_type, String separation_reason, String settlement, Date created_at, Date updated_at) {
        this.separation_id = separation_id;
        this.employee = employee;
        this.employee_department = employee_department;
        this.separate_date = separate_date;
        this.separation_type = separation_type;
        this.separation_reason = separation_reason;
        this.settlement = settlement;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    // Getter and Setter provide access to the private fields
    public int getSeparation_id() {
        return separation_id;
    }

    public void setSeparation_id(int separation_id) {
        this.separation_id = separation_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmployee_department() {
        return employee_department;
    }

    public void setEmployee_department(String employee_department) {
        this.employee_department = employee_department;
    }

    public void setSeparate_date(Date seperate_date) {
        this.separate_date = seperate_date;
    }

    public String getSeparation_type() {
        return separation_type;
    }

    public void setSeparation_type(String separation_type) {
        this.separation_type = separation_type;
    }

    public String getSeparation_reason() {
        return separation_reason;
    }

    public void setSeparation_reason(String separation_reason) {
        this.separation_reason = separation_reason;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getSeparation_date() {
        return null;
    }
}