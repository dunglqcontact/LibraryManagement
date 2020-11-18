<%-- 
    Document   : AdminPage
    Created on : Jul 6, 2020, 12:39:25 PM
    Author     : Dung
--%>

<%@page import="sample.dtos.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin's Page</title>
    </head>
    <body>
        <% UserDTO crUser = (UserDTO) session.getAttribute("USER");%>
        <h1>Welcome <%= crUser.getUserRole()%>: <%= crUser.getUserName()%></h1>
        <a href="MainController?btnAction=Logout">Logout</a>
        <br>
        <br>
        <%
            String login_user = crUser.getUserRole();
            if (login_user == null) {
                response.sendRedirect("login.html");
            }
        %>
        <a href="createNewAdmin.jsp">Create new Admin</a> 
        <br>
        <br>
        <%
            String searchUser = request.getParameter("txtSearchUser");
            if (searchUser == null) {
                searchUser = "";
            }
        %>
        <form action="MainController">
            Search User: <input type="text" name="txtSearchUser" value="<%= searchUser%>" placeholder="Input User Name to search"/>
            <input type="submit" name="btnAction" value="Search User"/>
        </form>

        <%! ArrayList<UserDTO> userList;%>
        <%
            userList = (ArrayList<UserDTO>) session.getAttribute("USER_LIST");
            if (userList != null) {
                if (!userList.isEmpty()) {
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>Number</th>
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>Role</th>
                    <th>Password</th>
                    <th>Order History</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : userList) {
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><%= user.getUserID()%></td>
                    <td><%= user.getUserName()%></td>
                    <td><%= user.getUserRole()%></td>
                    <td><%= user.getPassword()%></td>
                    <td><a href="MainController?btnAction=HistoryAD&txtUserID=<%= user.getUserID()%>&txtSearchUser=<%=request.getParameter("txtSearchUser")%>">Order History</a></td>
                    <td><a href="MainController?btnAction=DeleteUser&txtUserID=<%= user.getUserID()%>&txtSearchUser=<%=request.getParameter("txtSearchUser")%>">Delete</a></td>
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

        <%
            String searchBookAdmin = request.getParameter("txtSearchBookAdmin");
            if (searchBookAdmin == null) {
                searchBookAdmin = "";
            }
        %>

        <br>
        <br>


        <form action="MainController">
            Search <input type="text" name="txtSearchBookAdmin" value="<%= searchBookAdmin%>" placeholder="Input book name to search"/>
            <input type="submit" value="SearchBookAdmin" name="btnAction"/>
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
                    <th>Quantity</th>
                    <th>Current Quantity</th>
                    <th>Delete</th>
                    <th>Update</th>
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
                    <td><%= book.getQuantityOfBook()%></td>
                    <td><%= book.getCurrentQuantityOfBook()%></td>
                    <td><a href="MainController?btnAction=DeleteBook&txtBookID=<%=book.getBookID()%>&txtSearchBookAdmin=<%=request.getParameter("txtSearchBookAdmin")%>">Delete</a></td>
                    <td>
                        <form action="MainController">
                            <input type="hidden" name="txtUpdateBookID" value="<%= book.getBookID()%>"/>
                            <input type="hidden" name="txtUpdateBookTitle" value="<%= book.getBookTitle()%>"/>
                            <input type="hidden" name="txtUpdatePrice" value="<%= book.getPrice()%>"/>
                            <input type="hidden" name="txtUpdateAuthor" value="<%= book.getAuthor()%>"/>
                            <input type="hidden" name="txtUpdateQuantityOfBook" value="<%= book.getQuantityOfBook()%>"/>
                            <input type="submit" value="UpdateBook" name="btnAction"/>
                        </form>
                    </td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>
        <%
                }
            }
        %>

        <br>
        <br>

        <form action="MainController">
            <input type="submit" value="Insert new book" name="btnAction">
        </form>

    </body>
</html>
