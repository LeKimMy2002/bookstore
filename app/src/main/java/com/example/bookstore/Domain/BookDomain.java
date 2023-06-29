package com.example.bookstore.Domain;

import java.io.Serializable;

public class BookDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private String author;
    private String category;
    private Double fee;
    private int release_year;
    private Double star;
    private int numberInCart;

    public BookDomain(String title, String pic, String description, String author, String category, Double fee, int release_year, Double star) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.author = author;
        this.category = category;
        this.fee = fee;
        this.release_year = release_year;
        this.star = star;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getReleaseyear() {
        return release_year;
    }

    public void setReleaseyear(int release_year) {
        this.release_year = release_year;
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }
}
