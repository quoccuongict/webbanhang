/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quoc Cuong
 */
public class ProductDAO {
    Connection con = null;
    public ArrayList<Product> selectAll(){
        con = DBConnection.getConnection();
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "select * from tbl_product";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImage(rs.getString("image"));
                product.setPrice(rs.getFloat("price"));
                product.setDiscount(rs.getFloat("discount"));
                product.setSold(rs.getInt("sold"));
                product.setLocation(rs.getString("location"));
                product.setBrand(rs.getString("brand"));
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }
    
    public ArrayList<Product> getProduct(int start, int quantity){
        con = DBConnection.getConnection();
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM tbl_product Limit ?,?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, quantity);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImage(rs.getString("image"));
                product.setPrice(rs.getFloat("price"));
                product.setDiscount(rs.getFloat("discount"));
                product.setSold(rs.getInt("sold"));
                product.setLocation(rs.getString("location"));
                product.setBrand(rs.getString("brand"));
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }
    
    public ArrayList<Product> getProduct(String keyword, int start, int quantity){
        con = DBConnection.getConnection();
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM tbl_product where name like ? Limit ?,?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setInt(2, start);
            ps.setInt(3, quantity);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImage(rs.getString("image"));
                product.setPrice(rs.getFloat("price"));
                product.setDiscount(rs.getFloat("discount"));
                product.setSold(rs.getInt("sold"));
                product.setLocation(rs.getString("location"));
                product.setBrand(rs.getString("brand"));
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }
    
    public int getCount(){
        con = DBConnection.getConnection();
        String sql = "SELECT count(id) FROM tbl_product";
        int count = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    public int getCount(String keyword){
        con = DBConnection.getConnection();
        String sql = "SELECT count(id) FROM tbl_product where name like ?";
        int count = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public boolean addProduct(Product product){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "insert into tbl_product(name, image, price, discount, sold, location, brand) values(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getImage());
            ps.setFloat(3, product.getPrice());
            ps.setFloat(4, product.getDiscount());
            ps.setInt(5, product.getSold());
            ps.setString(6, product.getLocation());
            ps.setString(7, product.getBrand());
            int t = ps.executeUpdate();
            System.out.println(t);
            check = true;
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public boolean updateProduct(Product product){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "update tbl_product set name = ?, image = ?, price = ?, discount = ?, sold = ?, location = ?, brand = ? where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getImage());
            ps.setFloat(3, product.getPrice());
            ps.setFloat(4, product.getDiscount());
            ps.setInt(5, product.getSold());
            ps.setString(6, product.getLocation());
            ps.setString(7, product.getBrand());
            ps.setInt(8, product.getId());
            ps.executeUpdate();
            check = true;
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public boolean deleteProduct(Product product){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "delete from tbl_product where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, product.getId());
            ps.executeUpdate();
            check = true;
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
}
