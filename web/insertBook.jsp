<%-- 
    Document   : insertBook
    Created on : Jul 13, 2020, 12:14:45 PM
    Author     : Dung
--%>

<%@page import="sample.dtos.BookErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert book Page</title>
    </head>
    <body>
        <%
            BookErrorDTO error = (BookErrorDTO) request.getAttribute("INSERT_BOOK_ERROR");
            if (error == null) {
                error = new BookErrorDTO("", "", "", "", "","");
            }
        %>
        
        <form action="MainController">
            Book ID: <input type="text" name="txtInsertBookID"/><br>
            <%
                if (error.getBookIDError()!= null) {
            %>
            <%= error.getBookIDError()%> <br>
            <%
                }
            %>
            Book Title: <input type="text" name="txtInsertBookTitle"/><br>
            <%
                if (error.getBookTitleError()!= null) {
            %>
            <%= error.getBookTitleError()%> <br>
            <%
                }
            %>
            Author: <input type="text" name="txtInsertAuthor" /><br>
            <%
                if (error.getAuthorError()!= null) {
            %>
            <%= error.getAuthorError()%> <br>
            <%
                }
            %>
            Price: <input type="text" name="txtInsertPrice" /><br>
            <%
                if (error.getPriceError()!= null) {
            %>
            <%= error.getPriceError()%> <br>
            <%
                }
            %>
            Quantity Of Book: <input type="text" name="txtInsertQuantityOfBook" /><br>
            <%
                if (error.getQuantityOfBookError()!= null) {
            %>
            <%= error.getQuantityOfBookError()%> <br>
            <%
                }
            %>
            <input type="submit" value="Insert book" name="btnAction"/>
            <input type="reset" value="Reset"/>
            <br>
            <a href="adminPage.jsp">Return to admin Page</a>
        </form>
    </body>
</html>
