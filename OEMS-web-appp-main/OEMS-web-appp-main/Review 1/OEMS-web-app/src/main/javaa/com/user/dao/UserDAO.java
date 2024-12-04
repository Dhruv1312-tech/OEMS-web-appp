 package com.user.dao;

import com.user.model.User;
import com.user.model.Event;
import com.user.model.Ticket;
import com.user.model.Registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO {

    // *** User Operations ***
    public void createUser(User user) {
        String sql = "INSERT INTO users (name, email, role) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt("id"), resultSet.getString("name"),
                                resultSet.getString("email"), resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("name"),
                                   resultSet.getString("email"), resultSet.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // *** Event Operations ***
    public void createEvent(Event event) {
        String sql = "INSERT INTO events (title, description, date, time, venue, organizer_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, event.getTitle());
            statement.setString(2, event.getDescription());
            statement.setDate(3, Date.valueOf(event.getDate()));
            statement.setTime(4, Time.valueOf(event.getTime()));
            statement.setString(5, event.getVenue());
            statement.setInt(6, event.getOrganizerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Event getEventById(int id) {
        String sql = "SELECT * FROM events WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Event(resultSet.getInt("id"), resultSet.getString("title"),
                                 resultSet.getString("description"), resultSet.getDate("date").toLocalDate(),
                                 resultSet.getTime("time").toLocalTime(), resultSet.getString("venue"),
                                 resultSet.getInt("organizer_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // *** Ticket Operations ***
    public void createTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets (event_id, price, quantity) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ticket.getEventId());
            statement.setDouble(2, ticket.getPrice());
            statement.setInt(3, ticket.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> getTicketsByEventId(int eventId) {
        String sql = "SELECT * FROM tickets WHERE event_id = ?";
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tickets.add(new Ticket(resultSet.getInt("id"), resultSet.getInt("event_id"),
                                       resultSet.getDouble("price"), resultSet.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    // *** Registration Operations ***
    public void registerUser(Registration registration) {
        String sql = "INSERT INTO registrations (user_id, event_id) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, registration.getUserId());
            statement.setInt(2, registration.getEventId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Registration> getRegistrationsByEventId(int eventId) {
        String sql = "SELECT * FROM registrations WHERE event_id = ?";
        List<Registration> registrations = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                registrations.add(new Registration(resultSet.getInt("id"), resultSet.getInt("user_id"),
                                                   resultSet.getInt("event_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }
}
