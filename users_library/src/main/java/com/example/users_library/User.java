package com.example.users_library;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String description;
    private String birthDate;
    private String nation;
    private String imageUrl;
    private String brief;

    public String getBrief() {
        return brief;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getNation() {
        return nation;
    }
}
