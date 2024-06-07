package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "hrm_benefits")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "benefit_id" , nullable = false)
    private int benefit_id;

    @ManyToOne
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    private Employee employee;

    @Column(name = "benefit_type", nullable = false)
    private String benefit_type;

    @Column(name = "coverage_details", nullable = false)
    private String coverage_details;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    public Benefit()
    {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    public Benefit(int benefit_id, String benefit_type, Date start_date, String coverage_details, Date end_date, Date created_at, Date updated_at) {
        this.benefit_id = benefit_id;
        this.benefit_type = benefit_type;
        this.start_date = start_date;
        this.coverage_details = coverage_details;
        this.end_date = end_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getBenefit_id() {
        return benefit_id;
    }

    public void setBenefit_id(int benefit_id) {
        this.benefit_id = benefit_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getBenefit_type() {
        return benefit_type;
    }

    public void setBenefit_type(String benefit_type) {
        this.benefit_type = benefit_type;
    }

    public String getCoverage_details() {
        return coverage_details;
    }

    public void setCoverage_details(String coverage_details) {
        this.coverage_details = coverage_details;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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
}
