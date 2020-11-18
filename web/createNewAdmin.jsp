<%-- 
    Document   : createNewAdmin
    Created on : Jul 16, 2020, 4:12:23 PM
    Author     : Dung
--%>

<%@page import="sample.dtos.UserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Admin Account</title>
    </head>
    <body>
        <%
            UserErrorDTO error = (UserErrorDTO) request.getAttribute("ADMIN_ERROR");
            if (error == null){
                error = new UserErrorDTO("", "", "", "");
            }
        %>
        <form action="MainController">
            User ID <input type="text" name="txtUserID"/><br>
            <%
                if (error.getUserIDError()!= null) {
            %>
            <%= error.getUserIDError()%> <br>
            <%
                }
            %>
            User Name <input type="text" name="txtUserName"/><br>
            <%
                if (error.getUserNameError()!= null) {
            %>
            <%= error.getUserNameError()%> <br>
            <%
                }
            %>
            Password <input type="text" name="txtPassword"/><br>
            <%
                if (error.getPasswordError()!= null) {
            %>
            <%= error.getPasswordError()%> <br>
            <%
                }
            %>
            Re-password <input type="text" name="txtRePassword"/><br>
            <%
                if (error.getRePasswordError()!= null) {
            %>
            <%= error.getRePasswordError()%> <br>
            <%
                }
            %>
            <input type="submit" value="Create New Admin" name="btnAction"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
