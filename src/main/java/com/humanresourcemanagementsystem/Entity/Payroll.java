package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "hrm_payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payroll_id")
    private int payroll_id;

    @ManyToOne
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    private Employee employee;

    @Column(name = "pay_amount", nullable = false)
    private Float pay_amount;

    @Column(name = "bonus", nullable = false)
    private Float bonus;

    @Column(name = " increment_applicable")
    private Boolean increment_applicable;

    @Column(name = "percentage_increment ")
    private Float percentage_increment;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    // Constructors
    public Payroll() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    public Payroll(Float pay_amount, Float bonus, Boolean increment_applicable, Float percentage_increment,
                   Date created_at, Date updated_at) {
        this.pay_amount = pay_amount;
        this.bonus = bonus;
        this.increment_applicable = increment_applicable;
        this.percentage_increment = percentage_increment;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getPayroll_id() {
        return payroll_id;
    }

    public void setPayroll_id(int payroll_id) {
        this.payroll_id = payroll_id;
    }

    public Float getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(Float pay_amount) {
        this.pay_amount = pay_amount;
    }

    public Float getBonus() {
        return bonus;
    }

    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }

    public Boolean getIncrement_applicable() {
        return increment_applicable;
    }

    public void setIncrement_applicable(Boolean increment_applicable) {
        this.increment_applicable = increment_applicable;
    }

    public Float getPercentage_increment() {
        return percentage_increment;
    }

    public void setPercentage_increment(Float percentage_increment) {
        this.percentage_increment = percentage_increment;
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



