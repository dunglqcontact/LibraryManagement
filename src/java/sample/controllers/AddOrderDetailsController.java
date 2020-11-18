/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dtos.BookDTO;
import sample.dtos.OrderDetailsDTO;

/**
 *
 * @author Dung
 */
public class AddOrderDetailsController extends HttpServlet {

    private static final String ERROR = "invalid.jsp";
    private static final String SUCCESS = "SearchBookController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String bookID = request.getParameter("txtBookID");
            String bookTitle = request.getParameter("txtBookTitle");
            int price = Integer.parseInt(request.getParameter("txtPrice"));
            String txtAuthor = request.getParameter("txtAuthor");
            BookDTO book = new BookDTO(bookID, bookTitle, 1, price, txtAuthor);
            HttpSession session = request.getSession();
            OrderDetailsDTO orderDetails = (OrderDetailsDTO) session.getAttribute("ORDER_DETAILS");
            if (orderDetails == null) {
                orderDetails = new OrderDetailsDTO(null);
            }
            orderDetails.add(book);
            session.setAttribute("ORDER_DETAILS", orderDetails);
            request.setAttribute("message", "Ban da them vao san pham " + bookTitle + " thanh cong");
            url = SUCCESS;
        } catch (Exception e) {

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
