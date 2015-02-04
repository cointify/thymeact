package com.thymeweb.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

    @NotEmpty(message = "Please enter username")
    private String username;

    @NotEmpty(message = "Please enter first name")
    private String firstName;

    @NotEmpty(message = "Please enter last name")
    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
