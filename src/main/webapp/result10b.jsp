<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
    <h2>Final Result</h2>
    <% if(request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } else { %>
        <p>Roll No: <%= request.getAttribute("rollNo") %></p>
        <p>Name: <%= request.getAttribute("name") %></p>
        <p>Average: <%= request.getAttribute("avg") %>%</p>
        <p>Status: <b><%= request.getAttribute("result") %></b></p>
    <% } %>
    <br>
    <a href="index10b.jsp">Back to Entry</a>
</body>
</html>