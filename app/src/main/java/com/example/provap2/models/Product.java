package com.example.provap2.models;

import java.util.Random;

public class Product {
    private int id;
    private String name;
    private String description;
    private float price;
    private float rating;

    public Product(int id, String name, float price, float rating, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getOffer() {
        Random random = new Random();
        return random.nextInt(11) + 2;
    }
}
