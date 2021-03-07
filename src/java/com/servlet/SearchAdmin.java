package com.servlet;

import com.dao.ProductDAO;
import com.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");
        if(!keyword.equals("")){
            int first = 0;
            int last = 0;
            int total = new ProductDAO().getCount(keyword);
            if (total <= 20) {
                first = 0; 
                last = total; 
            } else {
                first = 0;
                last = 20;
            }

            ArrayList<Product> listProduct = new ProductDAO().getProduct(keyword, first, last);
            HttpSession session = request.getSession();
            session.setAttribute("listProduct", listProduct);
            String words[] = keyword.split("\\s++");
            String url = "";
            for(int i = 0; i < words.length - 1; i++){
                url += URLEncoder.encode(words[i], "UTF-8");
                url += " ";
            }
            url += URLEncoder.encode(words[words.length-1], "UTF-8");
            response.sendRedirect("search1.jsp?keyword=" + url);
        }
        else{
            response.sendRedirect("/WebsiteBanHang/admin.jsp");
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
