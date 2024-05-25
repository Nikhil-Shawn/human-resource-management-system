package com.humanresourcemanagementsystem.Entity;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "asset_id")
    private int asset_id;

    @ManyToOne
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    private Employee employee;

    @Column(name = "asset_type", nullable = false)
    private String asset_type;

    @Column(name = "serial_number", nullable = false , unique = true)
    private String serial_number;

    @Column(name = "issued_date")
    private Date issued_date;

    @Column(name = "return_date")
    private Date return_date;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    // Constructors
    public Asset() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    public Asset( String asset_type, String serial_number, Date issued_date, Date return_date,
                 Date created_at, Date updated_at ) {
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
}

