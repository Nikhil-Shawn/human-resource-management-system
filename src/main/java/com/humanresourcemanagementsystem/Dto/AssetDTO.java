package com.humanresourcemanagementsystem.Dto;

import java.time.LocalDate;

public class AssetDTO extends EmployeeDTO {

    private int asset_id;
    private String asset_type;
    private String serial_number;
    private LocalDate issued_date;
    private LocalDate return_date;
    private LocalDate created_at;
    private LocalDate updated_at;

    public AssetDTO(int EmployeeID, int asset_id , String asset_type , String serial_number, LocalDate issued_date
            ,LocalDate return_date, LocalDate created_at, LocalDate updated_at )
    {
        super(EmployeeID);
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

    public LocalDate getIssued_date() {
        return issued_date;
    }

    public void setIssued_date(LocalDate issued_date) {
        this.issued_date = issued_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }


    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "AssetDTO{" +
                "asset_id=" + asset_id +
                "EmployeeID=" + getEmployeeID() +
                "asset_type=" + getAsset_type() +
                "serial_number=" + getSerial_number() +
                "issued_date=" + getIssued_date() +
                "return_date=" + getReturn_date() +
                "created_at=" + getCreated_at()+
                "updated_at=" + getUpdated_at()+
                '}';
    }
}