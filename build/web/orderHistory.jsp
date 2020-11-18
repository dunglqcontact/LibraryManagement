<%-- 
    Document   : orderHistory
    Created on : Jul 14, 2020, 2:05:35 PM
    Author     : Dung
--%>

<%@page import="sample.dtos.OrderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>

        <%!
            ArrayList<OrderDTO> historyList;
        %>

        <%
            historyList = (ArrayList<OrderDTO>) session.getAttribute("HISTORY_LIST");
            if (historyList != null) {
                if (!historyList.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Number</th>
                    <th>Order ID</th>
                    <th>Get Date</th>
                    <th>Return Date</th>
                    <th>Status</th>
                    <th>View Details</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (OrderDTO order : historyList) {
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><%= order.getOrderID()%></td>
                    <td><%= order.getGetDate()%></td>
                    <td><%= order.getReturnDate()%></td>
                    <td><%= order.isStatus() %></td>
                    <td>
                        <a href="MainController?btnAction=ViewDetails&txtOrderID=<%= order.getOrderID()%>&txtSearchReturnOrder=<%=request.getParameter("txtSearchReturnOrder")%>">View Details</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
                }
            }
        %>
    </body>
</html>
