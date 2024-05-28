package com.humanresourcemanagementsystem.Dto;

import java.util.Date;

public class AssetDTO {

    private int asset_id;
    private int employee_id; // Added EmployeeID field
    private String asset_type;
    private String serial_number;
    private Date issued_date;
    private Date return_date;
    private Date created_at;
    private Date updated_at;

    // Constructors
    public AssetDTO() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    public AssetDTO(int employee_id, int asset_id, String asset_type, String serial_number, Date issued_date,
                    Date return_date, Date created_at, Date updated_at) {
        this.employee_id = employee_id;
        this.asset_id = asset_id;
        this.asset_type = asset_type;
        this.serial_number = serial_number;
        this.issued_date = issued_date;
        this.return_date = return_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getAsset_type() {
        return asset_type;
    }

    public void setAsset_type(String asset_type) {
        this.asset_type = asset_type;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Date getIssued_date() {
        return issued_date;
    }

    public void setIssued_date(Date issued_date) {
        this.issued_date = issued_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
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
        return "AssetDTO{" +
                "asset_id=" + asset_id +
                ", employee_id=" + employee_id +
                ", asset_type='" + asset_type + '\'' +
                ", serial_number='" + serial_number + '\'' +
                ", issued_date=" + issued_date +
                ", return_date=" + return_date +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
