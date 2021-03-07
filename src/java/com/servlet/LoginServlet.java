package com.servlet;

import com.dao.CartDAO;
import com.dao.OrderDAO;
import com.dao.UserDAO;
import com.handle.Utils;
import com.model.Cart;
import com.model.Order;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = new Utils().getMd5(request.getParameter("password"));
        UserDAO ud = new UserDAO();
        User user = new User();
        user = ud.checkLogin(email, password);
        boolean login = true;
        HttpSession session = request.getSession();
        if(user != null){
            session.setAttribute("user", user);
            CartDAO cartDAO = new CartDAO();
            Cart cart = cartDAO.getCart(user);
            session.setAttribute("cart", cart);
            OrderDAO orderDAO = new OrderDAO();
            ArrayList<Order> listOrder = new ArrayList<>();
            listOrder = orderDAO.getOrder(user);
            session.setAttribute("listOrder", listOrder);
        }
        session.setAttribute("login", login);
        if(user != null && user.getRole().equals("admin")){
            response.sendRedirect("admin.jsp");
        }
        else{
            response.sendRedirect("/WebsiteBanHang");
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
