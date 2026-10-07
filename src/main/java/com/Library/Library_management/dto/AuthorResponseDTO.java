package com.Library.Library_management.dto;

public class AuthorResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String bio;

    public AuthorResponseDTO(Long id,String name, String email,String bio){
        this.id = id;
        this.name = name;
        this.email = email;
        this.bio = bio;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getBio(){
        return bio;
    }

}
