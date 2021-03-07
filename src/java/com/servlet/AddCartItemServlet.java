package com.servlet;

import com.dao.CartDAO;
import com.model.Cart;
import com.model.CartItem;
import com.model.Product;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCartItemServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser == null){
            response.sendRedirect("/WebsiteBanHang");
        }
        else{
            int quantity = Integer.parseInt(request.getParameter("quantity"));       
            Product product = (Product)session.getAttribute("product");
            CartItem cartItem = new CartItem(product, quantity);
            User user = (User)session.getAttribute("user");
            CartDAO cartDAO = new CartDAO();
            int number = cartDAO.checkCartItem(user, product);
            boolean checkUpdateCartItem;
            if(number > 0){
                cartItem.setQuantity(quantity + number);
                checkUpdateCartItem = cartDAO.updateCartItem(user, cartItem);
            }
            else{
                checkUpdateCartItem = cartDAO.addCartItem(user, cartItem);
            }
            Cart cart = cartDAO.getCart(user);
            session.setAttribute("cart", cart);
            session.setAttribute("checkUpdateCartItem", checkUpdateCartItem);
            response.sendRedirect("cart.jsp");
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
