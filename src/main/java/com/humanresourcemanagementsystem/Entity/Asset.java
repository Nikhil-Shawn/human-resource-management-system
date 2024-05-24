package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;
import java.time.LocalDate;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "asset_id")
    private int asset_id;

    @ManyToOne
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    private Employee employee;

    // Additional asset details (you can add more fields as needed)
    private String asset_type;
    private String serial_number;
    private LocalDate issued_date;
    private LocalDate return_date;
    private LocalDate created_at;
    private LocalDate updated_at;

    // Constructors
    public Asset() {
    }

    public Asset( String asset_type, String serial_number, LocalDate issued_date, LocalDate return_date,
                 LocalDate created_at, LocalDate updated_at ) {
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
}

