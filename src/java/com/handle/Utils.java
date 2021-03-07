/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.handle;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;






/**
 *
 * @author Quoc Cuong
 */
public class Utils {
    public String convertPrice(float price){
        String ans = "";
        int priceInt = (int)price;
        int a[] = new int[20];
        int n = 0;
        while(priceInt != 0){
            a[n] = priceInt % 10;
            priceInt = priceInt/10;
            n++;
        }
        int tmp = 1;
        for(int i = 0; i < n; i++){
            ans = a[i] + ans;
            if(tmp % 3 == 0){
                ans = '.' + ans;
            }
            tmp++;
        }
        if(ans.charAt(0) == '.'){
            ans = ans.substring(1);
        }
        return ans;
    }
    
    public Timestamp convertStringtoTimestamp(String s){
        s = s.replace('-', '/');
        Date date = new Date();
        try { 
            date = new SimpleDateFormat("yyyy/MM/dd").parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }
    
    public String convertTimestamptoString(Timestamp ts){
        Date date = new Date(ts.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate  = dateFormat.format(date);
        return strDate;
    }
    
    public String convertImage(String image){
        image = image.substring(0, image.length()-4);
        image = "https://cf.shopee.vn/file/" + image;
        return image;
    }
    
    public String getMd5(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); 
        }
    }
    
    public static void main(String[] args) {
//        System.out.println(convertImage("c185bfb96500e9edd728ab6e5b9d9cc4_tn.jpg"));
//        System.out.println(convertStringtoTimestamp("2020-12-22"));
//        float price = (float)9937434.0;
//        System.out.println(price);
//        System.out.println(convertPrice(price));
    }
}
