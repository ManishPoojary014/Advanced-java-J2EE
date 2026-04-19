<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Check Session</title>
</head>
<body>
    <h1>Display the session value on this page</h1>
<%
    String name = (String)session.getAttribute("user");
    
    if (name == null) {
        out.print("<h3 style='color:red;'>Sorry, the session has ended.</h3>");
        out.print("<a href='index9c.jsp'>Back to Login</a>");
    } else {
        out.print("<h3 style='color:green;'>Hello " + name + "!</h3>");
        out.print("The session is still active.");
    }
%>
</body>
</html>