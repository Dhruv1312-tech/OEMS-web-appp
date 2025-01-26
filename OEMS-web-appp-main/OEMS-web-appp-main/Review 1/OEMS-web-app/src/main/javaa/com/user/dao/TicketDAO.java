package com.user.dao;

import com.user.model.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends AbstractDAO {

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
}