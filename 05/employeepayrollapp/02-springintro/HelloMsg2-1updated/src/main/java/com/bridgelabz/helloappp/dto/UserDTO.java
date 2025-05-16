package com.bridgelabz.helloappp.dto;

public class UserDTO {
    private String firstName;
    private String lastName;

    // Default constructor
    public UserDTO() {}

    // Parameterized constructor
    public UserDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
