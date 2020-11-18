<%-- 
    Document   : returnBookPage
    Created on : Jul 14, 2020, 12:46:13 PM
    Author     : Dung
--%>

<%@page import="sample.dtos.OrderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return Book Page</title>
    </head>
    <body>

        <%
            String searchReturnOrder = request.getParameter("txtSearchReturnOrder");
            if (searchReturnOrder == null) {
                searchReturnOrder = "";
            }
        %>
        <form action="MainController">
            Search <input type="text" name="txtSearchReturnOrder" value="<%= searchReturnOrder%>" placeholder="Insert get date to search"/>
            <input type="submit" value="Search Return Order" name="btnAction"/>
        </form>
        <%!
            ArrayList<OrderDTO> returnOrderList;
        %>

        <%
            returnOrderList = (ArrayList<OrderDTO>) session.getAttribute("RETURN_BOOK_LIST");
            if (returnOrderList != null) {
                if (!returnOrderList.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Number</th>
                    <th>Order ID</th>
                    <th>Get Date</th>
                    <th>Return Date</th>
                    <th>View Details</th>
                    <th>Check out</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (OrderDTO order : returnOrderList) {
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><%= order.getOrderID()%></td>
                    <td><%= order.getGetDate()%></td>
                    <td><%= order.getReturnDate()%></td>
                    <td>
                        <a href="MainController?btnAction=ViewDetails&txtOrderID=<%= order.getOrderID()%>&txtSearchReturnOrder=<%=request.getParameter("txtSearchReturnOrder")%>">View Details</a>
                    </td>
                    <td>
                        <form action="MainController">
                            <input type="hidden" name="txtOrderID" value="<%= order.getOrderID()%>"/>
                            <input type="submit" value="Check out" name="btnAction"/>
                        </form>
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
        
        <a href="userPage.jsp">User Page</a>
    </body>
</html>
