/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quoc Cuong
 */
public class UserDAO {
    Connection con = null;
    public User checkLogin(String email, String password){
        con = DBConnection.getConnection();
        User user = null;
        try {
            String sql = "SELECT * FROM tbl_user WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setGender(rs.getString("gender"));
                user.setDoB(rs.getTimestamp("dob"));
                user.setAvatar(rs.getString("avatar"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public boolean updateUser(User user){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "update tbl_user set username = ?, fullname = ?, phone = ?, gender = ?, dob = ?, avatar = ? where email = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getGender());
            ps.setTimestamp(5, user.getDoB());
            ps.setString(6, user.getAvatar());
            ps.setString(7, user.getEmail());
            ps.executeUpdate();
            check = true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            check = false;
        }
        return check;
    }
    
    public boolean checkUser(String email){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "SELECT * FROM tbl_user WHERE email = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public boolean addUser(User user){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "insert into tbl_user(email, password, avatar, role) values(?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAvatar());
            ps.setString(4, user.getRole());
            int t = ps.executeUpdate();
            System.out.println(t);
            check = true;
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
}
