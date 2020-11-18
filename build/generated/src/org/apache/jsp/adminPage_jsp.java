package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.dtos.BookDTO;
import java.util.ArrayList;
import sample.dtos.UserDTO;

public final class adminPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 ArrayList<UserDTO> userList;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin's Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 UserDTO crUser = (UserDTO) session.getAttribute("USER");
      out.write("\n");
      out.write("        <h1>Welcome ");
      out.print( crUser.getUserRole());
      out.write(':');
      out.write(' ');
      out.print( crUser.getUserName());
      out.write("</h1>\n");
      out.write("        <a href=\"MainController?btnAction=Logout\">Logout</a>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        ");

            String login_user = crUser.getUserRole();
            if (login_user == null) {
                response.sendRedirect("login.html");
            }
        
      out.write("\n");
      out.write("        <a href=\"createNewAdmin.jsp\">Create new Admin</a> \n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        ");

            String searchUser = request.getParameter("txtSearchUser");
            if (searchUser == null) {
                searchUser = "";
            }
        
      out.write("\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            Search User: <input type=\"text\" name=\"txtSearchUser\" value=\"");
      out.print( searchUser);
      out.write("\" placeholder=\"Input User Name to search\"/>\n");
      out.write("            <input type=\"submit\" name=\"btnAction\" value=\"Search User\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            userList = (ArrayList<UserDTO>) session.getAttribute("USER_LIST");
            if (userList != null) {
                if (!userList.isEmpty()) {
        
      out.write("\n");
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Number</th>\n");
      out.write("                    <th>User ID</th>\n");
      out.write("                    <th>User Name</th>\n");
      out.write("                    <th>Role</th>\n");
      out.write("                    <th>Password</th>\n");
      out.write("                    <th>Order History</th>\n");
      out.write("                    <th>Delete</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    int count = 1;
                    for (UserDTO user : userList) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( count++);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( user.getUserID());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( user.getUserName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( user.getUserRole());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( user.getPassword());
      out.write("</td>\n");
      out.write("                    <td><a href=\"MainController?btnAction=HistoryAD&txtUserID=");
      out.print( user.getUserID());
      out.write("&txtSearchUser=");
      out.print(request.getParameter("txtSearchUser"));
      out.write("\">Order History</a></td>\n");
      out.write("                    <td><a href=\"MainController?btnAction=DeleteUser&txtUserID=");
      out.print( user.getUserID());
      out.write("&txtSearchUser=");
      out.print(request.getParameter("txtSearchUser"));
      out.write("\">Delete</a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        ");

                }
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        ");

            String searchBookAdmin = request.getParameter("txtSearchBookAdmin");
            if (searchBookAdmin == null) {
                searchBookAdmin = "";
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            Search <input type=\"text\" name=\"txtSearchBookAdmin\" value=\"");
      out.print( searchBookAdmin);
      out.write("\" placeholder=\"Input book name to search\"/>\n");
      out.write("            <input type=\"submit\" value=\"SearchBookAdmin\" name=\"btnAction\"/>\n");
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
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Current Quantity</th>\n");
      out.write("                    <th>Delete</th>\n");
      out.write("                    <th>Update</th>\n");
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
      out.print( book.getQuantityOfBook());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( book.getCurrentQuantityOfBook());
      out.write("</td>\n");
      out.write("                    <td><a href=\"MainController?btnAction=DeleteBook&txtBookID=");
      out.print(book.getBookID());
      out.write("&txtSearchBookAdmin=");
      out.print(request.getParameter("txtSearchBookAdmin"));
      out.write("\">Delete</a></td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"MainController\">\n");
      out.write("                            <input type=\"hidden\" name=\"txtUpdateBookID\" value=\"");
      out.print( book.getBookID());
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"txtUpdateBookTitle\" value=\"");
      out.print( book.getBookTitle());
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"txtUpdatePrice\" value=\"");
      out.print( book.getPrice());
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"txtUpdateAuthor\" value=\"");
      out.print( book.getAuthor());
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"txtUpdateQuantityOfBook\" value=\"");
      out.print( book.getQuantityOfBook());
      out.write("\"/>\n");
      out.write("                            <input type=\"submit\" value=\"UpdateBook\" name=\"btnAction\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");

                }
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            <input type=\"submit\" value=\"Insert new book\" name=\"btnAction\">\n");
      out.write("        </form>\n");
      out.write("\n");
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
