package com.humanresourcemanagementsystem.Dto;

import java.util.Date;

public class ExperienceDTO {

    // Experience entity fields
    private int experience_id;
        private int person_id ;
        private int employee_id ;
        private String company_name;
        private String employment_type;
        private String  no_of_years;
        private String position;
        private Date start_date;
        private Date end_date;

    // Default constructor initializes created at and updated at field with current date
    public ExperienceDTO(){
    }

    //Parameterized constructor initializes all fields with provided values
    public ExperienceDTO(int experience_id, int person_id, int employee_id, String company_name, String employment_type, String no_of_years, String position, Date start_date, Date end_date) {
        this.experience_id = experience_id;
        this.person_id = person_id;
        this.employee_id = employee_id;
        this.company_name = company_name;
        this.employment_type = employment_type;
        this.no_of_years = no_of_years;
        this.position = position;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    // Getter and Setter provide access to the private fields
    public int getExperience_id() {
        return experience_id;
    }

    public void setExperience_id(int experience_id) {
        this.experience_id = experience_id;
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

    @Override
    //Provides detailed and formatted information about the object’s current state.
    public String toString() {
        return "ExperienceDTO{" +
                "experience_id=" + experience_id +
                ",person_id=" + person_id +
                ",employee_id=" + employee_id +
                ",company_name=" + company_name +
                ",employment_type='" + employment_type + '\'' +
                ",no_of_years='" + no_of_years + '\'' +
                ",position='" + position + '\'' +
                ",start_date=" + start_date +
                ",end_date=" + end_date +
                '}';
    }
}
