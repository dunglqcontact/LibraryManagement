/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dtos.DateErrorDTO;

/**
 *
 * @author Dung
 */
public class PocketController extends HttpServlet {

    private static final String ERROR = "userPage.jsp";
    private static final String SUCCESS = "pocket.jsp";

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
            DateErrorDTO error = new DateErrorDTO();
            String getDate = request.getParameter("txtGetDate");
            String returnDate = request.getParameter("txtReturnDate");
            boolean check = true;
            if (getDate.equals("")) {
                error.setGetDateError("Get Date must be not empty");
                check = false;
            }
            if (returnDate.equals("")) {
                error.setReturnDateError("Return Date must be not empty");
                check = false;
            } else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date convertGetDate = formatter.parse(getDate);
                    Date convertReturnDate = formatter.parse(returnDate);
                    if (convertGetDate.compareTo(convertReturnDate) > 0) {
                        error.setCompareDate("Get Date must be lowwer than Return Date");
                        check = false;
                    } else {
                        HttpSession session = request.getSession();
                        session.setAttribute("GET_DATE", getDate);
                        session.setAttribute("RETURN_DATE", returnDate);
                        check = true;
                    }
                } catch (ParseException e) {
                    check = false;
                }

            }
            if (check) {
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", error);
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
