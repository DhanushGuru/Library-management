package com.Library.Library_management.entity;

import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;

import jakarta.persistance;

@Entity
@Table(name = "books")

public class Book{

    @Id 
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private long id;

    @column(nullable = false)
    private String title;

    @column(nullable = false, unique = true)
    private String isbn;

    private String genre;

    private int totalCopies;

    private int availableCopies;

    public book(){
        // This one is required by Hibernate,
        // JPA's rule is: every @Entity class must have a public or protected no-argument constructor, even if you never call it yourself directly in your own code.
    }

    public Book(String title,String isbn, String genre, int totalCopies, int availableCopies){
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public Long getId(){
        return getId();
    }

    public Long setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public String setTitle(String title){
        this.title = title;
    }

    public String getIsbn(){
        return isbn;
    }

    public String setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getGenre(){
        return genre;
    }

    public String setGenre(String genre){
        this.genre = genre;
    }

    public String getTotalcopies(){
        return totalCopies;
    }

    public String setTotalcopies(int totalCopies){
        this.totalCopies = totalCopies;
    }

    public String getAvailablecopies(){
        return availableCopies;
    }

    public String setAvailablecopies(int availableCopies){
        this.availableCopies = availableCopies;
    }
}