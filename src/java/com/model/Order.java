/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Quoc Cuong
 */
public class Order implements Serializable{
    private int id;
    private User user;
    private Product product;
    private int quantity;
    private float amount;
    private Timestamp dateOrder;

    public Order() {
    }

    public Order(int id, User user, Product product, int quantity, float amount, Timestamp dateOrder) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.dateOrder = dateOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Timestamp getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user=" + user + ", product=" + product + ", quantity=" + quantity + ", amount=" + amount + ", dateOrder=" + dateOrder + '}';
    }
    
}
