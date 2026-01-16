package dao;

import model.Ticket;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {

    public void createTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets (customer_name, issue_description, priority, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ticket.getCustomerName());
            ps.setString(2, ticket.getIssueDescription());
            ps.setString(3, ticket.getPriority());
            ps.setString(4, ticket.getStatus());
            ps.executeUpdate();

            System.out.println("Ticket created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getString("customer_name"),
                        rs.getString("issue_description"),
                        rs.getString("priority"),
                        rs.getString("status")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}
