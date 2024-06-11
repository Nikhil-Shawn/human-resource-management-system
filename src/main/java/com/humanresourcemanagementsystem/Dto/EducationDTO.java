package com.humanresourcemanagementsystem.Dto;

import java.util.Date;

public class EducationDTO {

    // Education entity fields
    private int education_id;
    private int person_id; // Added PersonID field
    private int employee_id; // Added EmployeeID field
    private String degree;
    private String institution;
    private String major;
    private Date graduation_start_date;
    private Date graduation_end_date;
    private Date created_at;
    private Date updated_at;

    // Default constructor initializes created at and updated at field with current date
    public EducationDTO() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    //Parameterized constructor initializes all fields with provided values
    public EducationDTO(int education_id, int person_id, int employee_id, String institution, String degree, String major, Date graduation_start_date, Date graduation_end_date, Date created_at, Date updated_at) {
        this.education_id = education_id;
        this.person_id = person_id;
        this.employee_id = employee_id;
        this.institution = institution;
        this.degree = degree;
        this.major = major;
        this.graduation_start_date = graduation_start_date;
        this.graduation_end_date = graduation_end_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Getter and Setter provide access to the private fields
    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getGraduation_start_date() {
        return graduation_start_date;
    }

    public void setGraduation_start_date(Date graduation_start_date) {
        this.graduation_start_date = graduation_start_date;
    }

    public Date getGraduation_end_date() {
        return graduation_end_date;
    }

    public void setGraduation_end_date(Date graduation_end_date) {
        this.graduation_end_date = graduation_end_date;
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
    //Provides detailed and formatted information about the object’s current state.
    public String toString() {
        return "EducationDTO{" +
                "education_id=" + education_id +
                ", person_id=" + person_id +
                ", employee_id=" + employee_id +
                ", degree='" + degree + '\'' +
                ", institution='" + institution + '\'' +
                ", major='" + major + '\'' +
                ", graduation_start_date=" + graduation_start_date +
                ", graduation_end_date=" + graduation_end_date +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
