package com.springboot.main.dto;

public class UserEmailDTO {

    private String email;

    public UserEmailDTO() {
        // Default constructor
    }

    public UserEmailDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
