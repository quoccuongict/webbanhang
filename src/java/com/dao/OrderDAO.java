/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Order;
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
public class OrderDAO {
    Connection con = null;
    public boolean addOrder(Order order){
        con = DBConnection.getConnection();
        boolean check = false;
        String sql = "insert into tbl_order(userid, productid, quantity, amount, dateoder) values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order.getUser().getId());
            ps.setInt(2, order.getProduct().getId());
            ps.setInt(3, order.getQuantity());
            ps.setFloat(4, order.getAmount());
            ps.setTimestamp(5, order.getDateOrder());
            ps.executeUpdate();
            check = true;
        } catch (SQLException ex) {
            check = false;
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public ArrayList<Order> getOrder(User user){
        con = DBConnection.getConnection();
        ArrayList<Order> listOrder = new ArrayList<>();
        String sql = "select b.id, a.*, b.quantity, b.amount, b.dateoder from tbl_product a, tbl_order b, tbl_user c where b.userid = c.id and b.productid = a.id and b.userid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Order order = new Order();
                Product product = new Product();
                order.setUser(user);
                order.setId(rs.getInt(1));
                product.setId(rs.getInt(2));
                product.setName(rs.getString(3));
                product.setImage(rs.getString(4));
                product.setPrice(rs.getFloat(5));
                product.setDiscount(rs.getFloat(6));
                product.setSold(rs.getInt(7));
                product.setLocation(rs.getString(8));
                product.setBrand(rs.getString(9));
                order.setProduct(product);
                order.setQuantity(rs.getInt(10));
                order.setAmount(rs.getFloat(11));
                order.setDateOrder(rs.getTimestamp(12));
                listOrder.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }
}
