package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.dtos.DateErrorDTO;
import java.util.ArrayList;
import sample.daos.OrderDAO;
import sample.dtos.UserDTO;
import java.util.List;
import sample.dtos.BookDTO;
import sample.dtos.BookDTO;

public final class userPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            ArrayList<BookDTO> bookList;
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User's Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 UserDTO user = (UserDTO) session.getAttribute("USER");
      out.write("\n");
      out.write("        <h1>Welcome ");
      out.print( user.getUserRole());
      out.write(':');
      out.write(' ');
      out.print( user.getUserName());
      out.write("</h1>\n");
      out.write("        <a href=\"MainController?btnAction=Logout\">Logout</a>\n");
      out.write("\n");
      out.write("        ");

            String login_user = user.getUserRole();
            if (login_user == null) {
                response.sendRedirect("login.html");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        ");

            String searchBook = request.getParameter("txtSearchBook");
            if (searchBook == null) {
                searchBook = "";
            }
        
      out.write("\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            Search <input type=\"text\" name=\"txtSearchBook\" value=\"");
      out.print( searchBook);
      out.write("\" placeholder=\"Insert book to search\"/>\n");
      out.write("            <input type=\"submit\" value=\"SearchBook\" name=\"btnAction\"/>\n");
      out.write("        </form>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            bookList = (ArrayList<BookDTO>) session.getAttribute("BOOK_LIST");
            if (bookList != null) {
                if (!bookList.isEmpty()) {
        
      out.write("\n");
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Book ID</th>\n");
      out.write("                    <th>Title</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Author</th>\n");
      out.write("                    <th>Current Quantity</th>\n");
      out.write("                    <th>Add To Bag</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    for (BookDTO book : bookList) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( book.getBookID());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( book.getBookTitle());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( book.getPrice());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( book.getAuthor());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( book.getCurrentQuantityOfBook());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"MainController\">\n");
      out.write("                            <input type=\"hidden\" name=\"txtBookID\" value=\"");
      out.print( book.getBookID());
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"txtBookTitle\" value=\"");
      out.print( book.getBookTitle());
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"txtPrice\" value=\"");
      out.print( book.getPrice());
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"txtAuthor\" value=\"");
      out.print( book.getAuthor());
      out.write("\"/>\n");
      out.write("                            <input type=\"submit\" value=\"Add to Bag\" name=\"btnAction\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");

            DateErrorDTO error = (DateErrorDTO) request.getAttribute("ERROR");
            if (error == null) {
                error = new DateErrorDTO("", "", "");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            Get Date: <input type=\"date\" name=\"txtGetDate\" placeholder=\"dd/mm/yyyy\"/> <br>\n");
      out.write("            ");

                if (error.getGetDateError() != null) {
            
      out.write("\n");
      out.write("            ");
      out.print( error.getGetDateError());
      out.write(" <br>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            Return Date: <input type=\"date\" name=\"txtReturnDate\" placeholder=\"dd/mm/yyyy\"/> <br>\n");
      out.write("            \n");
      out.write("            ");

                if (error.getReturnDateError()!= null) {
            
      out.write("\n");
      out.write("            ");
      out.print( error.getReturnDateError());
      out.write(" <br>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("            \n");
      out.write("            ");

                if (error.getCompareDate()!= null) {
            
      out.write("\n");
      out.write("            ");
      out.print( error.getCompareDate());
      out.write(" <br>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\" value=\"Pocket\" name=\"btnAction\"/>\n");
      out.write("        </form>\n");
      out.write("        ");

                }
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
 if (request.getAttribute("message") != null) {
      out.write("\n");
      out.write("        ");
      out.print( request.getAttribute("message"));
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <a href=\"returnBookPage.jsp\">Check out Page</a>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <a href=\"MainController?btnAction=History\">History</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
