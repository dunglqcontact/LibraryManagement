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
import sample.daos.BookDAO;
import sample.dtos.BookDTO;
import sample.dtos.BookErrorDTO;

/**
 *
 * @author Dung
 */
public class UpdateBookController extends HttpServlet {

    private static final String ERROR = "updateBook.jsp";
    private static final String SUCCESS = "SearchBookAdminController";

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
            HttpSession session = request.getSession();
            BookDAO dao = new BookDAO();
            BookErrorDTO error = new BookErrorDTO();
            boolean check = true;
            String bookID = request.getParameter("txtUpdateBookID");
            String bookTitle = request.getParameter("txtUpdateBookTitle");
            String priceNotCast = request.getParameter("txtUpdatePrice");
            int price = 0;
            String quantityOfBookNotCast = request.getParameter("txtUpdateQuantityOfBook");
            int quantityOfBook = 0;
            String author = request.getParameter("txtUpdateAuthor");

            if (bookTitle.isEmpty() || bookTitle.length() < 2) {
                error.setBookTitleError("Book title must not lower than 2 character");
                check = false;
            }

            if (!priceNotCast.isEmpty()) {
                price = Integer.parseInt(priceNotCast);
                if (price <= 0 || price > 1000000000) {
                    error.setBookTitleError("Price must be greater than 0 and lower than 1.000.000.000");
                    check = false;
                }
            } else {
                error.setPriceError("Price must not be empty");
                check = false;
            }
            if (!quantityOfBookNotCast.isEmpty()) {
                quantityOfBook = Integer.parseInt(quantityOfBookNotCast);
                if (quantityOfBook < 0 || quantityOfBook > 1000000000) {
                    error.setBookTitleError("Quantity Of Book must be greater than 0 and lower than 1.000.000.000");
                    check = false;
                }
            } else {
                error.setQuantityOfBookError("Quantity Of Book must not be empty");
                check = false;
            }

            if (author.isEmpty() || author.length() < 2) {
                error.setAuthorError("Author must not lower than 2 character");
                check = false;
            }

            if (check) {
                BookDTO book = new BookDTO(bookID, bookTitle, quantityOfBook, price, author);
                dao.update(book);
                url = SUCCESS;
            } else {
                request.setAttribute("UPDATE_BOOK_ERROR", error);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
