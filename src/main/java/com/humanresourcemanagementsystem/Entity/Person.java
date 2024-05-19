package com.humanresourcemanagementsystem.Entity;

public interface Person {

    // Getters
    int getPersonID();
    String getFirstName();
    String getLastName();
    String getAddress();
    String getEmail();
    String getPhone();
    String getDateOfBirth();
    String getGender();
    String getNationality();
    String getMaritalStatus();
    String getPersonType();

    // Setters
    void setPersonID(int personID);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setAddress(String address);
    void setEmail(String email);
    void setPhone(String phone);
    void setDateOfBirth(String dateOfBirth);
    void setGender(String gender);
    void setNationality(String nationality);
    void setMaritalStatus(String maritalStatus);
    void setPersonType(String personType);
}
