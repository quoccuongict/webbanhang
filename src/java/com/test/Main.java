/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.dao.CartDAO;
import com.dao.OrderDAO;
import com.dao.ProductDAO;
import com.dao.UserDAO;
import com.handle.Utils;
import com.model.Cart;
import com.model.CartItem;
import com.model.Order;
import com.model.Product;
import com.model.User;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quoc Cuong
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        
//          Product product = new Product();
//          product.setId(7);
//          User user = new User();
//          user.setId(1);
//          CartDAO cartDAO = new CartDAO();
//          CartItem cartItem = new CartItem();
//          cartItem.setId(10);
////          cartItem.setProduct(product);
////          cartItem.setQuantity(3);
//          boolean check = cartDAO.deleteCartItem(cartItem);
//          System.out.println(check);
//          
//        product.setName("Điện thoại Vivo Y30i 4Gb + 64Gb - Hàng chính hãng");
//        product.setImage("https://cf.shopee.vn/file/71f0fe93ecf9903094e006ae8f81f25f_tn");
//        product.setPrice(3990000);
//        product.setDiscount(29);
//        product.setSold(0);
//        product.setLocation("TP. Hồ Chí Minh");
//        product.setBrand("Asus");
//        ProductDAO pdDAO = new ProductDAO();
//        boolean check = pdDAO.addProduct(product);
//        System.out.println(check);

//        String s = "c185bfb96500e9edd728ab6e5b9d9cc4_tn.jpg";
//        s = s.substring(0, s.length()-4);
//        s = "https://cf.shopee.vn/file/" + s;
//        System.out.println(s);

//        UserDAO ud = new UserDAO();
//        User user = new User();
//        user = ud.checkLogin("abc@gmail.com", "12345");
//        System.out.println(user.getRole());
//        User user = new User();
//        user.setId(2);
//        Cart cart = new Cart();
//        CartDAO cartDAO = new CartDAO();
//        cart = cartDAO.getCart(user);
//        System.out.println(cart.getCartItems().size());
////        Product product = cart.getCartItems().get(0).getProduct();
////        System.out.println(product.getId() + "\n" + product.getName() + "\n" + product.getImage() + "\n" + product.getPrice() + "\n" + product.getDiscount() + "\n" + product.getSold() + "\n" + product.getLocation() + "\n" + product.getBrand());
//        for(int i = 0; i < cart.getCartItems().size(); i++){
//            System.out.println(cart.getCartItems().get(i).getId() + " " + cart.getCartItems().get(i).getProduct().toString() + " " + cart.getCartItems().get(i).getQuantity());
//        }

//        user.setEmail("hihi@gmail.com");
//        user.setPassword("pass");
//        user.setAvatar("avatar1.png");
//        UserDAO ud = new UserDAO();
//        boolean check = ud.checkUser("hih@gmail.com");
//        System.out.println(check);
//        ProductDAO pdDAO = new ProductDAO();
//        ArrayList<Product> listProduct = new ArrayList<>();
//        listProduct = pdDAO.getProduct("Iphone", 1, 4);
//        for(Product product : listProduct){
//            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
//        }
//        UserDAO ud = new UserDAO();
//        User user = new User();
//        user = ud.checkLogin("abc@gmail.com", "12345");
//        System.out.println(user);
//        if(user != null){
//            System.out.println(user.getEmail());
//        }
//        else{
//            System.out.println("1");
//        }
//        String keyword = "điện thoại";
//        String words[] = keyword.split("\\s++");
//        String url = "";
//        for(int i = 0; i < words.length; i++){
//            try {
//                url += URLEncoder.encode(words[i], "UTF-8");
//            } catch (UnsupportedEncodingException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        System.out.println(url);

//        String s = "2020-12-22";
//        s = s.replace('-', '/');
//        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(s);
//        Timestamp ts = new Timestamp(date.getTime());
//        Date date1 = new Date(ts.getTime());
//        System.out.println(date1);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String string  = dateFormat.format(date1);
//        System.out.println(string);

//        User user = new User();
//        user.setEmail("abc@gmail.com");
//        user.setUsername("hoquoccuong");
//        user.setFullname("Hồ Quốc Cường");
//        user.setPhone("0123456789");
//        user.setGender("male");
//        user.setDoB(ts);
//        user.setAvatar("avatar1.png");
//        UserDAO ud = new UserDAO();
//        boolean check = ud.updateUser(user);
//        System.out.println(check);
//        System.out.println(ts);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1=dateFormat.parse(s); 
//        System.out.println(date1);
//        Timestamp dateTimeStamp = new Timestamp(date1.getTime()); 
//        System.out.println(dateTimeStamp);

//        Date date = new Date();
//        Timestamp ts = new Timestamp(date.getTime());
//        System.out.println(ts);
//        Order order = new Order();
//        User user = new User();
//        user.setId(1);
//        Product product = new Product();
//        product.setId(1);
//        order.setUser(user);
//        order.setProduct(product);
//        order.setQuantity(2);
//        order.setAmount(10000);
//        order.setDateOrder(ts);
//        OrderDAO odDAO = new OrderDAO();
//        boolean check = odDAO.addOrder(order);
//        System.out.println(check);
        Utils instance = new Utils();
        String s = "123456";
        String mahoa = instance.getMd5(s);
        String mahoa1 = instance.getMd5(mahoa);
        if(s.equals(mahoa)){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
        System.out.println(mahoa);

//        User user = new User();
//        user.setId(2);
//        ArrayList<Order> list = new OrderDAO().getOrder(user);
//        System.out.println(list.size());
    }
}
