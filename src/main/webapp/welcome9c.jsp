<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Session Started</title>
</head>
<body>
<%
    String name = request.getParameter("uname");
    String timeStr = request.getParameter("expiryTime");
    
    if (name != null && timeStr != null) {
        int minutes = Integer.parseInt(timeStr);
        int seconds = minutes * 60; // Convert minutes to seconds

        session.setAttribute("user", name);
        session.setMaxInactiveInterval(seconds); // Setting dynamic expiry

        out.print("Welcome! " + name);
        out.print("<br>Session has started for " + name);
        out.print("<br>Your name has been stored in the session object.");
        out.print("<br><b>Session Expiry set to: " + minutes + " minute(s).</b>");
        out.print("<br><br>Kindly press the following link to check it within the set time " +
                  "or wait here for the duration set to see the session expiry.<br>");
    }
%>
<br>
<a href="second9c.jsp">Display the value</a>
</body>
</html>