<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.eventmanagement.model.User" %>
<html>
<head>
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .profile-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
        }
        .profile-item {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="profile-container">
        <h2>User Profile</h2>
        <% 
            User user = (User) request.getAttribute("user"); // Get user object from the servlet
            if (user != null) {
        %>
            <div class="profile-item"><strong>Username:</strong> <%= user.getUsername() %></div>
            <div class="profile-item"><strong>Email:</strong> <%= user.getEmail() %></div>
        <% 
            } else { 
        %>
            <p>No user data found. Please register or log in.</p>
        <% 
            } 
        %>
        <a href="logout" style="color: blue; text-decoration: underline;">Logout</a>
    </div>
</body>
</html>
