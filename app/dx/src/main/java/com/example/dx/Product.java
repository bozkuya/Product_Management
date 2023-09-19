package com.example.dx;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Define a JPA entity for Product
@Entity
public class Product {
    // Define ID as primary key and set auto-generation strategy
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Declare instance variables
    private Long id;
    private String name;
    private String code;
    private String description;
    private String brand;
    private String currency;
    private double price;
    private int stock;

    public Product() {
        // Default constructor
    }

    public Product(String name, String code, String description, String brand, String currency, double price, int stock) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.brand = brand;
        this.currency = currency;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getCurrency() {
        return currency;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
