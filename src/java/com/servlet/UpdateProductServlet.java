package com.servlet;

import com.dao.ProductDAO;
import com.handle.Utils;
import com.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Product product = (Product)session.getAttribute("product");
        String isAction = request.getParameter("action");
        ProductDAO productDAO = new ProductDAO();
        if(isAction.equals("Update")){
            String name = request.getParameter("nameproduct");
            String image = request.getParameter("im-product");
            Utils instance = new Utils();
            if(image.equals("")){
                image = product.getImage();
            }
            else{
                image = instance.convertImage(image);
            }
            float price = Float.parseFloat(request.getParameter("priceproduct"));
            float discount = Float.parseFloat(request.getParameter("discountproduct"));
            int sold = 0;
            String location = request.getParameter("locationproduct");
            String brand = request.getParameter("brandproduct");
            product.setName(name);
            product.setImage(image);
            product.setPrice(price);
            product.setDiscount(discount);
            product.setLocation(location);
            product.setBrand(brand);
            boolean isUpdateProduct = productDAO.updateProduct(product);
            if(isUpdateProduct){
                session.setAttribute("product", product);
            }
            session.setAttribute("isUpdateProduct", isUpdateProduct);
            
        }
        else{
            if(isAction.equals("Delete")){
                boolean isDeleteProduct = productDAO.deleteProduct(product);
                if(isDeleteProduct){
                    session.removeAttribute("product");
                }
                session.setAttribute("isDeleteProduct", isDeleteProduct);
            }
        }
        response.sendRedirect("admin.jsp");
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
