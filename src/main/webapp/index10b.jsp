<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
    <h2>Student Mark Entry</h2>
    <form action="ResultServlet" method="POST">
        Roll No: <input type="text" name="rollNo" required><br>
        Name: <input type="text" name="studentName" required><br>
        Sub 1: <input type="number" name="sub1" min="0" max="100" required><br>
        Sub 2: <input type="number" name="sub2" min="0" max="100" required><br>
        Sub 3: <input type="number" name="sub3" min="0" max="100" required><br>
        Sub 4: <input type="number" name="sub4" min="0" max="100" required><br>
        Sub 5: <input type="number" name="sub5" min="0" max="100" required><br>
        <input type="submit" value="Calculate Result">
    </form>
</body>
</html>