package com.humanresourcemanagementsystem.Dto;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;
import java.time.LocalDate;
import java.util.Date;

public class AssetDTO extends EmployeeDTO {

    private int asset_id;
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


    public AssetDTO(int EmployeeID, int asset_id , String asset_type , String serial_number, Date issued_date
            ,Date return_date, Date created_at, Date updated_at )
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
