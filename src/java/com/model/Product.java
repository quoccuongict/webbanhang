/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 *
 * @author Quoc Cuong
 */
public class Product implements Serializable{
    private int id;
    private String name;
    private String image;
    private float price;
    private float discount;
    private int sold;
    private String location;
    private String brand;

    public Product() {
    }

    public Product(int id, String name, String image, float price, float discount, int sold, String location, String brand) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.sold = sold;
        this.location = location;
        this.brand = brand;
    }

    public Product(String name, String image, float price, float discount, int sold, String location, String brand) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.sold = sold;
        this.location = location;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", discount=" + discount + ", sold=" + sold + ", location=" + location + ", brand=" + brand + '}';
    }
}
