<%-- 
    Document   : pocket
    Created on : Jul 9, 2020, 7:46:49 PM
    Author     : Dung
--%>

<%@page import="sample.dtos.BookDTO"%>
<%@page import="sample.dtos.OrderDetailsDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User's Pocket</title>
    </head>
    <body>
        <h1>Your Pocket</h1>
        <%
            OrderDetailsDTO orderDetails = (OrderDetailsDTO) session.getAttribute("ORDER_DETAILS");
            if (orderDetails != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Number</th>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Get Date</th>
                    <th>Return Date</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <%
                int count = 1;
                for (BookDTO dto : orderDetails.getCart().values()) {

            %>
            <tbody>
                <tr>
                    <td><%= count++%></td>
                    <td><%= dto.getBookTitle()%></td>
                    <td><%= dto.getAuthor()%></td>
                    <td>
                        <%= session.getAttribute("GET_DATE")%>
                    </td>
                    <td>
                        <%= session.getAttribute("RETURN_DATE")%>
                    </td>
                    <td>
                        <%= dto.getQuantityOfBook()%>
                    </td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>
        <%
            }
        %>
        <form action="MainController">
            <input type="submit" value="Order" name="btnAction"/><br>

        </form>
        <a href="userPage.jsp">Back to User Page</a>
    </body>
</html>
