package com.user.dao;

import com.user.model.Registration;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO extends AbstractDAO {

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

    public List<Registration> getRegistrationsByUserId(int userId) {
        String sql = "SELECT * FROM registrations WHERE user_id = ?";
        List<Registration> registrations = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
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
