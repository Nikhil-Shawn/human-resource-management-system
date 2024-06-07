package com.humanresourcemanagementsystem.Dto;


public class LoginDTO {
    private String email;
    private String password;
    private String personType;

    public LoginDTO(String email, String password, String personType) {
        this.email = email;
        this.password = password;
        this.personType = personType;
    }

    public LoginDTO() {
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", personType='" + personType + '\'' +
                '}';
    }
}

