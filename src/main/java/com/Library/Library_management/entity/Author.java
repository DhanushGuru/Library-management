package com.Library.Library_management.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String bio;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private List<Book> books;

    public Author(){
        /* empty constructor */
    }

    public Author(String name, String email,String bio){
        this.name = name;
        this.email = email;
        this.bio = bio;     
    }
    public Long getId() { 
        return id;
    }
    public void setId(Long id) {
         this.id = id; 
    }
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

    public List<Book> getBooks(){
        return books;
    }
    public void setBooks(List<Book> books){
        this.books = books;
    }
    
}
