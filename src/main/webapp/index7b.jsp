<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Cookie Management</title>
</head>

<body>

<h2>Cookie Management System</h2>

<form action="addCookie.jsp" method="post">

    Name: <input type="text" name="cname" required><br><br>

    Domain: <input type="text" name="cdomain" required><br><br>

    Max Age (seconds): <input type="number" name="cmaxage" required><br><br>

    <input type="submit" value="Add Cookie">

</form>

</body>
</html>