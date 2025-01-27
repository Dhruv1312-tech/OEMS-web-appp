<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.eventmanagement.model.User" %>
<html>
<head>
    <title>User List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">User List</h2>
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<User> users = (List<User>) request.getAttribute("userList"); // Get the list of users from the servlet
                if (users != null && !users.isEmpty()) {
                    for (User user : users) {
            %>
                        <tr>
                            <td><%= user.getUsername() %></td>
                            <td><%= user.getEmail() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="2" style="text-align: center;">No users found.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
