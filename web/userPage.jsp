<%-- 
    Document   : userPage
    Created on : Jul 6, 2020, 12:40:29 PM
    Author     : Dung
--%>

<%@page import="sample.dtos.DateErrorDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.daos.OrderDAO"%>
<%@page import="sample.dtos.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.dtos.BookDTO"%>
<%@page import="sample.dtos.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User's Page</title>
    </head>
    <body>
        <% UserDTO user = (UserDTO) session.getAttribute("USER");%>
        <h1>Welcome <%= user.getUserRole()%>: <%= user.getUserName()%></h1>
        <a href="MainController?btnAction=Logout">Logout</a>

        <%
            String login_user = user.getUserRole();
            if (login_user == null) {
                response.sendRedirect("login.html");
            }
        %>

        <%
            String searchBook = request.getParameter("txtSearchBook");
            if (searchBook == null) {
                searchBook = "";
            }
        %>
        <form action="MainController">
            Search <input type="text" name="txtSearchBook" value="<%= searchBook%>" placeholder="Insert book to search"/>
            <input type="submit" value="SearchBook" name="btnAction"/>
        </form>
        <%!
            ArrayList<BookDTO> bookList;
        %>

        <%
            bookList = (ArrayList<BookDTO>) session.getAttribute("BOOK_LIST");
            if (bookList != null) {
                if (!bookList.isEmpty()) {
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>Book ID</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Author</th>
                    <th>Current Quantity</th>
                    <th>Add To Bag</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (BookDTO book : bookList) {
                %>
                <tr>
                    <td><%= book.getBookID()%></td>
                    <td><%= book.getBookTitle()%></td>
                    <td><%= book.getPrice()%></td>
                    <td><%= book.getAuthor()%></td>
                    <td><%= book.getCurrentQuantityOfBook()%></td>
                    <td>
                        <form action="MainController">
                            <input type="hidden" name="txtBookID" value="<%= book.getBookID()%>"/>
                            <input type="hidden" name="txtBookTitle" value="<%= book.getBookTitle()%>"/>
                            <input type="hidden" name="txtPrice" value="<%= book.getPrice()%>"/>
                            <input type="hidden" name="txtAuthor" value="<%= book.getAuthor()%>"/>
                            <input type="submit" value="Add to Bag" name="btnAction"/>
                        </form>
                    </td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>

        <%
            DateErrorDTO error = (DateErrorDTO) request.getAttribute("ERROR");
            if (error == null) {
                error = new DateErrorDTO("", "", "");
            }
        %>

        <form action="MainController">
            Get Date: <input type="date" name="txtGetDate" placeholder="dd/mm/yyyy"/> <br>
            <%
                if (error.getGetDateError() != null) {
            %>
            <%= error.getGetDateError()%> <br>
            <%
                }
            %>
            
            
            
            Return Date: <input type="date" name="txtReturnDate" placeholder="dd/mm/yyyy"/> <br>
            
            <%
                if (error.getReturnDateError()!= null) {
            %>
            <%= error.getReturnDateError()%> <br>
            <%
                }
            %>
            

            
            <%
                if (error.getCompareDate()!= null) {
            %>
            <%= error.getCompareDate()%> <br>
            <%
                }
            %>
            
            <br>
            <input type="submit" value="Pocket" name="btnAction"/>
        </form>
        <%
                }
            }
        %>

        <% if (request.getAttribute("message") != null) {%>
        <%= request.getAttribute("message")%>
        <%}%>

        <br>
        <br>

        <a href="returnBookPage.jsp">Check out Page</a>

        <br>
        <br>

        <a href="MainController?btnAction=History">History</a>
    </body>
</html>
