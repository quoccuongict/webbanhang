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
public class User implements Serializable{
    private int id;
    private String email;
    private String password;
    private String username;
    private String fullname;
    private String phone;
    private Timestamp doB;
    private String gender;
    private String avatar;
    private String role;

    public User() {
    }

    public User(int id, String email, String password, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User(int id, String email, String password, String username, String fullname, String phone, Timestamp doB, String gender, String avatar) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.fullname = fullname;
        this.phone = phone;
        this.doB = doB;
        this.gender = gender;
        this.avatar = avatar;
    }

    public User(String email, String password, String username, String fullname, String phone, Timestamp doB, String gender, String avatar) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.fullname = fullname;
        this.phone = phone;
        this.doB = doB;
        this.gender = gender;
        this.avatar = avatar;
    }

    public User(String email, String password, String avatar) {
        this.email = email;
        this.password = password;
        this.avatar = avatar;
    }

    public User(String email, String password, String avatar, String role) {
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getDoB() {
        return doB;
    }

    public void setDoB(Timestamp doB) {
        this.doB = doB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", username=" + username + ", fullname=" + fullname + ", phone=" + phone + ", doB=" + doB + ", gender=" + gender + ", avatar=" + avatar + '}';
    }
    
}
