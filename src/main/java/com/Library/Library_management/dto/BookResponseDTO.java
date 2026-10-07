package com.Library.Library_management.dto;
import com.Library.Library_management.entity.Author;

public class BookResponseDTO {
    private Long id;
    private String title;
    private String isbn;
    private String genre;
    private int totalCopies;
    private int availableCopies;
    private String authorName;

    public BookResponseDTO(Long id, String title, String isbn, String genre, int totalCopies, int availableCopies,String authorName){
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.authorName = authorName;
    }
    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getGenere(){
        return genre;
    }
    public int getTotalCopies(){
        return totalCopies;
    }
    public int getAvailableCopies(){
        return availableCopies;
    }
    public String getAuthorName(){
        return authorName;
    }
}
