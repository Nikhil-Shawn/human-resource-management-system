package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "hrm_experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private int  experienceID;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "employment_type")
    private String employment_type;

    @Column(name = "no_of_years")
    private String no_of_years;

    @Column(name = "position")
    private String position;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    public Experience() {
    }

    public Experience(int experienceID, String company_name, String employment_type, String no_of_years, String position, Date start_date, Date end_date, Person person) {
        this.experienceID = experienceID;
        this.company_name = company_name;
        this.employment_type = employment_type;
        this.no_of_years = no_of_years;
        this.position = position;
        this.start_date = start_date;
        this.end_date = end_date;
        this.person = person;
    }

    public int getExperienceID() {
        return experienceID;
    }

    public void setExperienceID(int experienceID) {
        this.experienceID = experienceID;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    public String getNo_of_years() {
        return no_of_years;
    }

    public void setNo_of_years(String no_of_years) {
        this.no_of_years = no_of_years;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}

