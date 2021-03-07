/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Cart;
import com.model.CartItem;
import com.model.Product;
import com.model.User;
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
public class CartDAO {
    Connection con = null;
    public Cart getCart(User user){
        con = DBConnection.getConnection();
        Cart cart = new Cart();
        ArrayList<CartItem> listCartItems = new ArrayList<>();
        String sql = "select b.id, a.*, b.quantity from tbl_product a, tbl_cart b, tbl_user c where b.productid = a.id and b.userid = c.id and c.id = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(2));
                product.setName(rs.getString(3));
                product.setImage(rs.getString(4));
                product.setPrice(rs.getFloat(5));
                product.setDiscount(rs.getFloat(6));
                product.setSold(rs.getInt(7));
                product.setLocation(rs.getString(8));
                product.setBrand(rs.getString(9));
                
                CartItem cartItem = new CartItem();
                cartItem.setId(rs.getInt(1));
                cartItem.setProduct(product);
                cartItem.setQuantity(rs.getInt(10));
                
                listCartItems.add(cartItem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        cart.setUser(user);
        cart.setCartItems(listCartItems);
        return cart;
    }
    
    public int checkCartItem(User user, Product product){
        con = DBConnection.getConnection();
        int quantity = 0;
        String sql = "select * from tbl_cart where userid = ? and productid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, product.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                quantity = rs.getInt("quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quantity;
    }
    
    public boolean addCartItem(User user, CartItem cartItem){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "insert into tbl_cart(userid, productid, quantity) values(?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, cartItem.getProduct().getId());
            ps.setInt(3, cartItem.getQuantity());
            ps.executeUpdate();
            check = true;
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public boolean updateCartItem(User user, CartItem cartItem){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "update tbl_cart set quantity = ? where userid = ? and productid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartItem.getQuantity());
            ps.setInt(2, user.getId());
            ps.setInt(3, cartItem.getProduct().getId());
            ps.executeUpdate();
            check = true;
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public boolean deleteCartItem(CartItem cartItem){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "delete from tbl_cart where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartItem.getId());
            ps.executeUpdate();
            check = true;
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
}
