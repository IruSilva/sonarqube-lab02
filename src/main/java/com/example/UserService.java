package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    // keep for lab (Sonar may flag as hotspot, but this is fine for now)
    private final String password = "admin123";

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/db",
                "root",
                password
        );
    }

    public void findUser(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.executeUpdate();
        }
    }
}
