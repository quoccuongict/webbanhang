/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Quoc Cuong
 */
public class Cart implements Serializable{
    private int id;
    private User user;
    private ArrayList<CartItem> cartItems;

    public Cart() {
    }

    public Cart(User user, ArrayList<CartItem> cartItems) {
        this.user = user;
        this.cartItems = cartItems;
    }

    public Cart(int id, User user, ArrayList<CartItem> cartItems) {
        this.id = id;
        this.user = user;
        this.cartItems = cartItems;
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

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    
    public float calculatorPrice(){
        float total = 0;
        for(int i = 0; i < cartItems.size(); i++){
            total += cartItems.get(i).getProduct().getPrice();
        }
        return total;
    }
    
    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", user=" + user + ", cartItems=" + cartItems + '}';
    }
    
}
