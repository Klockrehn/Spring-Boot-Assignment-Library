package com.example.librarysystem.dto;

public class BookDTO {
    private Long id;
    private String title;
    private int publicationYear;
    private int availableCopies;
    private int totalCopies;

    private Long authorId;
    private String authorFullName;

    public BookDTO() {}

    public BookDTO(Long id, String title, int publicationYear, int availableCopies, int totalCopies, Long authorId, String authorFullName) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
        this.authorId = authorId;
        this.authorFullName = authorFullName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public int getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies; }

    public int getTotalCopies() { return totalCopies; }
    public void setTotalCopies(int totalCopies) { this.totalCopies = totalCopies; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public String getAuthorFullName() { return authorFullName; }
    public void setAuthorFullName(String authorFullName) { this.authorFullName = authorFullName; }
}

