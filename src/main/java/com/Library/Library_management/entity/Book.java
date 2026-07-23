package com.Library.Library_management.entity;

// import java.lang.annotation.Inherited;
// import javax.annotation.processing.Generated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;

@Entity
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title must not be empty")
    @Size(min=1, max = 255, message = "Title must be between 1 to 255 charectars")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "ISBN must not be empty")
    @Size(min = 10, max = 20, message = "Isbn must be between 10 to 20 charectars")
    @Column(nullable = false, unique = true)
    private String isbn;

    @NotBlank(message = "genre must not be empty")
    private String genre;

    @NotNull(message = "Totalcopies must not be null")
    @Min(value = 1,message = "Total copies must be at least 1")
    private Integer totalCopies;

    @NotNull(message = "AvailableCopies must not be null")
    @Min(value=0, message = "AvailableCopies cannot be negative")
    private Integer availableCopies;

    public Book() {
        // This one is required by Hibernate,
        // JPA's rule is: every @Entity class must have a public or protected
        // no-argument constructor, even if you never call it yourself directly in your
        // own code.
    }

    public Book(String title, String isbn, String genre, int totalCopies, int availableCopies) {
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}