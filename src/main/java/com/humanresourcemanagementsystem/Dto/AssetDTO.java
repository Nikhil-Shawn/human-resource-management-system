package com.humanresourcemanagementsystem.Dto;

public class AssetDTO extends EmployeeDTO {

    private int Id;

    public AssetDTO(int EmployeeID, int AssetID ) {
        super(EmployeeID);
        this.Id = AssetID;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "AssetDTO{" +
                "Id=" + Id +
                '}';
    }
}
