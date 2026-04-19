<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Data Form</title>
    <style>
        .form-container { width: 300px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; font-family: sans-serif; }
        .form-field { margin: 10px 0; }
        label { display: block; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Enter User Data</h2>
        <form action="processUser" method="POST">
            <div class="form-field">
                <label>Username:</label>
                <input type="text" name="username" required>
            </div>
            <div class="form-field">
                <label>Email:</label>
                <input type="email" name="email" required>
            </div>
            <div class="form-field">
                <label>Designation:</label>
                <input type="text" name="designation" required>
            </div>
            <div class="form-field">
                <input type="submit" value="Submit">
            </div>
        </form>
    </div>
</body>
</html>