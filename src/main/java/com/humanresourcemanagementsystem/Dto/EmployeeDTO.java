package com.humanresourcemanagementsystem.Dto;

public class EmployeeDTO extends PersonDTO {

    private int employeeID;

    public EmployeeDTO(int personID, String firstName, String lastName, String email, String phone, int employeeID) {
        super(personID, firstName, lastName, email, phone);
        this.employeeID = employeeID;
    }

    public EmployeeDTO(int EmployeeID) {
        this.employeeID = EmployeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeID=" + employeeID +
                ", personID=" + getPersonID() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone='" + getPhone() + '\'' +
                '}';
    }
}
