package com.example.acm.Models.mlh;

public class Announcement {
    private String title;
    private String author;
    private String body;
    private String date;
    private String imageUrl;

    //Default Constructor
    public Announcement (){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Announcement(String title, String author, String body, String date, String imageUrl) {
        this.title = title;
        this.author = author;
        this.body = body;
        this.date = date;
        this.imageUrl = imageUrl;
    }
}
