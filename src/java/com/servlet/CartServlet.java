package com.servlet;

import com.dao.CartDAO;
import com.dao.OrderDAO;
import com.model.Cart;
import com.model.Order;
import com.model.Product;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String checkbox[] = new String[100];
        checkbox = request.getParameterValues("checkproduct");
        int index[] = new int[checkbox.length];
        for(int i = 0; i < checkbox.length; i++){
            index[i] = Integer.parseInt(checkbox[i]);
        }
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        User user = (User)session.getAttribute("user");
        String iAction = request.getParameter("action");
        CartDAO cartDAO = new CartDAO();
        if(iAction.equals("Order")){
            ArrayList<Order> listOrder = new ArrayList<>();
            Date date = new Date();
            float amount = 0;
            Timestamp ts = new Timestamp(date.getTime());
            for(int i = 0; i < index.length; i++){
                Order order = new Order();
                order.setUser(user);
                Product product = cart.getCartItems().get(index[i]).getProduct();
                order.setProduct(product);
                order.setQuantity(cart.getCartItems().get(index[i]).getQuantity());
                order.setDateOrder(ts);
                float price = cart.getCartItems().get(index[i]).getProduct().getPrice() - cart.getCartItems().get(index[i]).getProduct().getPrice()*cart.getCartItems().get(index[i]).getProduct().getDiscount()/100;
                amount = price*cart.getCartItems().get(index[i]).getQuantity();
                order.setAmount(amount);
                listOrder.add(order);
            }
            OrderDAO orderDAO = new OrderDAO();
            for(int i = 0; i < listOrder.size(); i++){
                boolean checkAddOrder = orderDAO.addOrder(listOrder.get(i));
                boolean checkDeleteCartItem = cartDAO.deleteCartItem(cart.getCartItems().get(index[i]));
            }
            cart = cartDAO.getCart(user);
            session.setAttribute("cart", cart);
            session.setAttribute("checkOrder", true);
            ArrayList<Order> list = new ArrayList<>();
            list = new OrderDAO().getOrder(user);
            session.setAttribute("listOrder", list);
            response.sendRedirect("cart.jsp");
        }
        else{
            if(iAction.equals("Delete")){
                for(int i = 0; i < index.length; i++){
                    boolean checkDeleteCartItem = cartDAO.deleteCartItem(cart.getCartItems().get(index[i]));
                }
                cart = cartDAO.getCart(user);
                session.setAttribute("cart", cart);
                response.sendRedirect("cart.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
