package com.humanresourcemanagementsystem.Dto;

import java.math.BigDecimal;
import java.util.Date;

public class PayrollDTO {

    // Payroll entity fields
    private Long payroll_id;
    private int employeeId;
    private BigDecimal payAmount;
    private String payFrequency;
    private BigDecimal bonus;
    private Boolean incrementApplicable;
    private BigDecimal percentageIncrement;
    private Date createdAt;
    private Date updatedAt;

    // Getter and Setter provide access to the private fields
    public Long getPayroll_id() {
        return payroll_id;
    }

    public void setPayroll_id(Long payroll_id) {
        this.payroll_id = payroll_id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

