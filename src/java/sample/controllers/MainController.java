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

/**
 *
 * @author Dung
 */
public class MainController extends HttpServlet {

    private static final String LOGIN = "LoginController";
    private static final String ERROR = "invalid.jsp";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH_BOOK = "SearchBookController";
    private static final String ADD_ORDER = "AddOrderDetailsController";
    private static final String POCKET = "PocketController";
    private static final String ORDER = "OrderController";
    private static final String SEARCH_USER = "SearchUserController";
    private static final String SEARCH_BOOK_ADMIN = "SearchBookAdminController";
    private static final String DELETE_BOOK = "DeleteBookController";
    private static final String UPDATE_BOOK_PAGE = "updateBook.jsp";
    private static final String UPDATE_BOOK = "UpdateBookController";
    private static final String INSERT_BOOK_PAGE = "insertBook.jsp";
    private static final String INSERT_BOOK = "InsertNewBookController";
    private static final String DELETE_USER = "DeleteUserController";
    private static final String INSERT_CUSTOMER = "CreateNewCustomerController";
    private static final String SEARCH_RETURN_ORDER = "SearchReturnOrderController";
    private static final String CHECK_OUT = "CheckOutController";
    private static final String VIEW_DETAILS_PAGE = "ViewDetailsController";
    private static final String HISTORY = "HistoryController";
    private static final String HISTORY_ADMIN = "HistoryControllerAdmin";
    private static final String INSERT_ADMIN = "CreateNewAdminController";

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
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Logout")) {
                url = LOGOUT;
            } else if (action.equals("SearchBook")) {
                url = SEARCH_BOOK;
            } else if (action.equals("Add to Bag")) {
                url = ADD_ORDER;
            } else if (action.equals("Pocket")) {
                url = POCKET;
            } else if (action.equals("Order")) {
                url = ORDER;
            } else if (action.equals("Search User")) {
                url = SEARCH_USER;
            } else if (action.equals("SearchBookAdmin")) {
                url = SEARCH_BOOK_ADMIN;
            } else if (action.equals("DeleteBook")) {
                url = DELETE_BOOK;
            } else if (action.equals("UpdateBook")) {
                url = UPDATE_BOOK_PAGE;
            } else if (action.equals("Update")) {
                url = UPDATE_BOOK;
            } else if (action.equals("Insert new book")) {
                url = INSERT_BOOK_PAGE;
            } else if (action.equals("Insert book")) {
                url = INSERT_BOOK;
            } else if (action.equals("DeleteUser")) {
                url = DELETE_USER;
            } else if (action.equals("Create New Customer")) {
                url = INSERT_CUSTOMER;
            } else if (action.equals("Search Return Order")) {
                url = SEARCH_RETURN_ORDER;
            } else if (action.equals("Check out")) {
                url = CHECK_OUT;
            } else if (action.equals("ViewDetails")) {
                url = VIEW_DETAILS_PAGE;
            } else if (action.equals("History")) {
                url = HISTORY;
            } else if (action.equals("HistoryAD")) {
                url = HISTORY_ADMIN;
            } else if (action.equals("Create New Admin")) {
                url = INSERT_ADMIN;
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
