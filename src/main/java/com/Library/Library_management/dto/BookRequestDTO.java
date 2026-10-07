package com.Library.Library_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public class BookRequestDTO {
    @NotBlank(message = "Title must not be empty.")
    @Size(min = 1, max= 255, message = "Title must be between 1 to 255 charecters")
    private String title;

    @NotBlank(message = "ISBN must not be empty")
    @Size(min = 10, max = 20, message = "ISBN must be between 10 and 20 characters")
    private String isbn;

    @NotBlank(message = "Genre must not be empty")
    @Size(min=1, max=255, message = "Genre must be between 1 to 255 charecters")
    private String genre;

    @NotNull(message = "Totalcopies must not be null")
    @Min(value = 1, message = "Totalcopies must be atleset 1 ")
    private Integer totalCopies;

    @NotNull(message = "available copies can not be null")
    @Min(value = 0, message = "Available copies can not be negative")
    private Integer availableCopies;

    private Long authorId;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
     public String getIsbn() { 
        return isbn; 
    }
    public void setIsbn(String isbn) { 
        this.isbn = isbn; 
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public Integer getTotalCopies(){
        return totalCopies;
    }
    public void setTotalCopies(Integer totalCopies){
        this.totalCopies = totalCopies;
    }
    public Integer getAvailableCopies(){
        return availableCopies;
    }
    public void setAvailableCopies(Integer availableCopies){
        this.availableCopies = availableCopies;
    }
    public Long getAuthorId(){
        return authorId;
    }
    public void setAuthorId(Long authorId){
        this.authorId = authorId;
    }
}
