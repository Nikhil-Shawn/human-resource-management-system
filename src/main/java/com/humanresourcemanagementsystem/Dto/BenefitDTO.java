package com.humanresourcemanagementsystem.Dto;

import java.util.Date;

public class BenefitDTO {

        private int benefit_id ;
        private int employee_id; // Added EmployeeID field
        private String benefit_type ;
        private Date start_date ;
        private String coverage_details ;
        private Date end_date;
        private Date created_at ;
        private Date updated_at ;

    public BenefitDTO() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    public BenefitDTO(int employee_id, int benefit_id, String benefit_type, Date start_date, String coverage_details, Date end_date, Date created_at, Date updated_at) {
        this.employee_id = employee_id ;
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

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getBenefit_type() {
        return benefit_type;
    }

    public void setBenefit_type(String benefit_type) {
        this.benefit_type = benefit_type;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getCoverage_details() {
        return coverage_details;
    }

    public void setCoverage_details(String coverage_details) {
        this.coverage_details = coverage_details;
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

    @Override
    public String toString() {
        return "BenefitDTO{" +
                "benefit_id=" + benefit_id +
                ",employee_id=" + employee_id +
                ",benefit_type='" + benefit_type + '\'' +
                ",coverage_details='" + coverage_details + '\'' +
                ",start_date=" + start_date +
                ",end_date=" + end_date +
                ",created_at=" + created_at +
                ",updated_at=" + updated_at +
                '}';
    }
}
