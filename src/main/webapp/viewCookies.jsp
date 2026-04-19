<%@ page import="javax.servlet.http.Cookie" %>
<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>Active Cookies</title>
</head>

<body>

<h2>Active Cookie List</h2>

<%
Cookie[] cookies = request.getCookies();

if (cookies != null && cookies.length > 0) {
    for (Cookie c : cookies) {
%>

<p>
    <b>Name:</b> <%= c.getName() %> |
    <b>Value:</b> <%= c.getValue() %> |
    <b>Max Age:</b> <%= c.getMaxAge() %>
</p>

<%
    }
} else {
%>

<p>No Active Cookies Found</p>

<%
}
%>

<br>

<a href="index7b.jsp">Back</a>

</body>
</html>