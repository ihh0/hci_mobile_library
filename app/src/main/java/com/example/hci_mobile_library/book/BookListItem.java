package com.example.hci_mobile_library.book;

public class BookListItem {
    private String name;
    private String author;
    private String publisher;
    private int image;

    // Constructor
    public BookListItem(String name, String author, String publisher, int image) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.image = image;
    }

    // Access methods
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

