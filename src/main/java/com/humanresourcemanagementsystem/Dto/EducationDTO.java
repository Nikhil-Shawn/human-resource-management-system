package com.humanresourcemanagementsystem.Dto;

import java.util.Date;

public class EducationDTO {

    private int education_id;
    private int person_id; // Added PersonID field
    private String degree;
    private String institution;
    private String major;
    private Date graduation_start_date;
    private Date graduation_end_date;
    private Date created_at;
    private Date updated_at;

    // Constructors
    public EducationDTO() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    public EducationDTO(int education_id, int person_id, String degree, String institution, String major, Date graduation_start_date, Date graduation_end_date, Date created_at, Date updated_at) {
        this.education_id = education_id;
        this.person_id = person_id;
        this.degree = degree;
        this.institution = institution;
        this.major = major;
        this.graduation_start_date = graduation_start_date;
        this.graduation_end_date = graduation_end_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

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
    public String toString() {
        return "EducationDTO{" +
                "education_id=" + education_id +
                ", person_id=" + person_id +
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
