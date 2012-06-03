package com.aman.domain;

public class Book {
    private String name;
    private String author;
    private String bookId;
    private String description;
    private String publisher;
    private int copies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getbookId() {
        return bookId;
    }

    public void setbookId(String bookId) {
        this.bookId = bookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setCopies(String copies) {
        // TODO Auto-generated method stub
        this.copies = Integer.parseInt(copies);
    }

}