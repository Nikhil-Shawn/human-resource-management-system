package com.humanresourcemanagementsystem.Dto;

import java.util.Date;

public class SeparationDTO {

    // Separation entity fields
    private int separation_id;
    private int employee_id;
    private String employee_department;
    private String settlement;
    private Date separation_date;
    private String separation_type;
    private String separation_reason;
    private Date created_at;
    private Date updated_at;

    // Default constructor initializes created at and updated at field with current date
    public SeparationDTO() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    //Parameterized constructor initializes all fields with provided values

    public SeparationDTO(int separation_id, int employee_id, String employee_department, String settlement, Date separation_date, String separation_reason, String separation_type, Date created_at, Date updated_at) {
        this.separation_id = separation_id;
        this.employee_id = employee_id;
        this.employee_department = employee_department;
        this.settlement = settlement;
        this.separation_date = separation_date;
        this.separation_reason = separation_reason;
        this.separation_type = separation_type;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Getter and Setter provide access to the private fields
    public int getSeparation_id() {
        return separation_id;
    }

    public void setSeparation_id(int separation_id) {
        this.separation_id = separation_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_department() {
        return employee_department;
    }

    public void setEmployee_department(String employee_department) {
        this.employee_department = employee_department;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public Date getSeparation_date() {
        return separation_date;
    }

    public void setSeparation_date(Date separation_date) {
        this.separation_date = separation_date;
    }

    public String getSeparation_type() {
        return separation_type;
    }

    public void setSeparation_type(String separation_type) {
        this.separation_type = separation_type;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getSeparation_reason() {
        return separation_reason;
    }

    public void setSeparation_reason(String separation_reason) {
        this.separation_reason = separation_reason;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    //Provides detailed and formatted information about the object’s current state.
    @Override
    public String toString() {
        return "SeparationDTO{" +
                "separation_id=" + separation_id +
                ", employee_id=" + employee_id +
                ", employee_department='" + employee_department +
                ", separation_date='" + separation_date +
                ", separation_type='" + separation_type +
                ", separation_reason='" + separation_reason +
                ", settlement=" + settlement +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
