package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "hrm_education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private int education_id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @Column(name = "degree", nullable = false)
    private String degree;

    @Column(name = "institution", nullable = false , unique = true)
    private String institution;

    @Column(name = "major", nullable = false , unique = true)
    private String major;

    @Column(name = "graduation_start_date")
    private Date graduation_start_date;

    @Column(name = "graduation_end_date")
    private Date graduation_end_date;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    public Education() {
        this.created_at = new Date();
        this.updated_at= new Date();
    }

    public Education(int education_id, Person person, String degree, String institution, String major, Date graduation_start_date, Date graduation_end_date, Date created_at, Date updated_at) {
        this.education_id = education_id;
        this.person = person;
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

    public int getPerson() {
        return person.getPersonID();
    }

    public void setPerson(Person person) {
        this.person = person;
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

}

