package com.Library.Library_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public class AuthorRequestDTO {
    @NotBlank(message = "Author name must not be empty")
    private String name;
    @Email(message = "Please provide valid email ")
    private String email;

    private String bio;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getBio(){
        return bio;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
}
