package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation-based configuration for the servlet URL
@WebServlet("/event")
public class EventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Welcome to Event Management System</h1>");
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Retrieve form data from the request
    String name = request.getParameter("name");
    String date = request.getParameter("date");
    String location = request.getParameter("location");

    // Optionally, you can validate the data here
    if (name == null || name.isEmpty() || date == null || date.isEmpty() || location == null || location.isEmpty()) {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Error: All fields are required!</h1>");
        return; // Stop further processing if validation fails
    }

    // Set attributes for forwarding to JSP
    request.setAttribute("eventName", name);
    request.setAttribute("eventDate", date);
    request.setAttribute("eventLocation", location);

    // Forward data to a JSP for display
    RequestDispatcher dispatcher = request.getRequestDispatcher("event_confirmation.jsp");
    dispatcher.forward(request, response);
}

