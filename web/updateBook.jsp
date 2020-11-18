<%-- 
    Document   : updateBook
    Created on : Jul 12, 2020, 11:43:39 PM
    Author     : Dung
--%>

<%@page import="sample.dtos.BookErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Book</title>
    </head>
    <body>

        <%
            BookErrorDTO error = (BookErrorDTO) request.getAttribute("UPDATE_BOOK_ERROR");
            if (error == null) {
                error = new BookErrorDTO("", "", "", "", "", "");
            }
        %>

        <form action="MainController">

            Book ID: <input type="text" name="txtUpdateBookID" value="<%= request.getParameter("txtUpdateBookID")%>" readonly="true" /><br>
            <br>
            <%
                if (error.getBookIDError()
                        != null) {
            %>
            <%= error.getBookIDError()%> <br>
            <%
                }
            %>
            <br>
            Book Title: <input type="text" name="txtUpdateBookTitle" value="<%= request.getParameter("txtUpdateBookTitle")%>"/><br>
            <br>
            <%
                if (error.getBookTitleError()
                        != null) {
            %>
            <%= error.getBookTitleError()%> <br>
            <%
                }
            %>
            <br>
            Author: <input type="text" name="txtUpdateAuthor" value="<%= request.getParameter("txtUpdateAuthor")%>"/><br>
            <br>
            <%
                if (error.getAuthorError()
                        != null) {
            %>
            <%= error.getAuthorError()%> <br>
            <%
                }
            %>
            <br>
            Price: <input type="text" name="txtUpdatePrice" value="<%= request.getParameter("txtUpdatePrice")%>"/><br>
            <br>
            <%
                if (error.getPriceError()
                        != null) {
            %>
            <%= error.getPriceError()%> <br>
            <%
                }
            %>
            <br>
            Quantity Of Book: <input type="text" name="txtUpdateQuantityOfBook" value="<%= request.getParameter("txtUpdateQuantityOfBook")%>"/><br>
            <br>
            <%
                if (error.getQuantityOfBookError()
                        != null) {
            %>
            <%= error.getQuantityOfBookError()%> <br>
            <%
                }
            %>
            <br>
            <input type="submit" value="Update" name="btnAction"/>
            <input type="reset" value="Reset"/>
            <br>
            <a href="adminPage.jsp">Return to admin Page</a>
        </form>
    </body>
</html>
