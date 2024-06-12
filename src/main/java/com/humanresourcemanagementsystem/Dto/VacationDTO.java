package com.humanresourcemanagementsystem.Dto;

import java.util.Date;

public class VacationDTO {

    // Vacation entity fields
    private int vacation_id;
    private int employeeId;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String status;
    private String vacationType;
    private Date createdAt;
    private Date updatedAt;

    // Getter and Setter provide access to the private fields
    public int getVacationId() {
        return vacation_id;
    }

    public void setVacationId(int vacation_id) {
        this.vacation_id = vacation_id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
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
