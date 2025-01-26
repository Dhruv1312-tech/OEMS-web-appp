package com.eventmanagement.servlet;

import com.eventmanagement.dao.UserDAO;
import com.eventmanagement.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

@WebServlet("/userRegistration")
public class UserRegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Basic validation
        if (password.equals(confirmPassword)) {
            // Create a new User object with the form data
            User user = new User(username, email, password);

            // Create UserDAO object to interact with the database
            UserDAO userDAO = new UserDAO();

            // Try to register the user by saving to the database
            if (userDAO.registerUser(user)) {
                // Store user information in the session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("email", email);
                
                // Forward request and data to userProfile.jsp using RequestDispatcher
                RequestDispatcher dispatcher = request.getRequestDispatcher("userProfile.jsp");
                request.setAttribute("user", user); // Setting user object to be accessed in JSP
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorMessage", "User registration failed. Please try again.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("user_registration.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Passwords do not match.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("user_registration.jsp");
            dispatcher.forward(request, response);
        }
    }
}
