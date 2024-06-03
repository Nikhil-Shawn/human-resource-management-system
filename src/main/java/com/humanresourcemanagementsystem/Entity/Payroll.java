package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "hrm_payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payroll_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    private Employee employee;

    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    @Column(name = "pay_frequency")
    private String payFrequency;

    private BigDecimal bonus;

    @Column(name = "increment_applicable")
    private Boolean incrementApplicable;

    @Column(name = "percentage_increment")
    private BigDecimal percentageIncrement;

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


    public Long getPayroll_id() {
        return payroll_id;
    }

    public void setPayroll_id(Long payroll_id) {
        this.payroll_id = payroll_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public Boolean getIncrementApplicable() {
        return incrementApplicable;
    }

    public void setIncrementApplicable(Boolean incrementApplicable) {
        this.incrementApplicable = incrementApplicable;
    }

    public BigDecimal getPercentageIncrement() {
        return percentageIncrement;
    }

    public void setPercentageIncrement(BigDecimal percentageIncrement) {
        this.percentageIncrement = percentageIncrement;
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
