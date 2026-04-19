<%@ page import="javax.servlet.http.Cookie" %>
<%@ page language="java" %>

<%
String name = request.getParameter("cname");
String domain = request.getParameter("cdomain");
int maxAge = Integer.parseInt(request.getParameter("cmaxage"));

Cookie cookie = new Cookie(name, domain);
cookie.setMaxAge(maxAge);

response.addCookie(cookie);
%>

<!DOCTYPE html>
<html>
<head>
<title>Cookie Added</title>
</head>

<body>

<h2>Cookie Created Successfully</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= maxAge %> seconds</p>

<br>

<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>