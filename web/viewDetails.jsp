<%-- 
    Document   : viewDetails
    Created on : Jul 14, 2020, 1:35:55 PM
    Author     : Dung
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="sample.dtos.BookDTO"%>
<%@page import="sample.dtos.OrderDetailsDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View order details</title>
    </head>
    <body>
        <%
            ArrayList<OrderDetailsDTO> orderDetails = (ArrayList<OrderDetailsDTO>) session.getAttribute("DETAILS");
            if (orderDetails != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Number</th>
                    <th>Order ID</th>
                    <th>Book Name</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <%
                int count = 1;
                 for (OrderDetailsDTO dto : orderDetails) {

            %>
            <tbody>
                <tr>
                    <td><%= count++%></td>
                    <td><%= dto.getOrderID() %></td>
                    <td><%= dto.getBookName()%></td>
                    <td><%= dto.getQuantity()%></td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>
        <%
            }
        %>
    </body>
</html>
