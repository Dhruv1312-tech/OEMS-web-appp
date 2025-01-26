package com.user.dao;

import com.user.model.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO extends AbstractDAO {

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

    public List<Event> getAllEvents() {
        String sql = "SELECT * FROM events";
        List<Event> events = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                events.add(new Event(resultSet.getInt("id"), resultSet.getString("title"),
                                     resultSet.getString("description"), resultSet.getDate("date").toLocalDate(),
                                     resultSet.getTime("time").toLocalTime(), resultSet.getString("venue"),
                                     resultSet.getInt("organizer_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
}