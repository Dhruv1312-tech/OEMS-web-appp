<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h2>User Profile</h2>
    <%
        // Retrieving user information from the session
        String username = (String) session.getAttribute("username");
        String email = (String) session.getAttribute("email");
    %>
    <p><strong>Username:</strong> <%= username %></p>
    <p><strong>Email:</strong> <%= email %></p>

    <a href="logout">Logout</a>
</body>
</html>
