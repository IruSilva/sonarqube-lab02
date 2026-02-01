package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    // still simple for lab, but not hardcoded
    private final String password;

    public UserService() {
        // Reads from environment variable. In GitHub Actions you can set it as a secret if needed.
        this.password = System.getenv("DB_PASSWORD");
    }

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/db",
                "root",
                password
        );
    }

    // Fixed: PreparedStatement prevents SQL injection + closes resources safely
    public void findUser(String username) throws SQLException {
        String query = "SELECT id, name FROM users WHERE name = ?";


        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                // no-op (lab)
            }
        }
    }

    // Fixed: PreparedStatement + try-with-resources
    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn = openConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.executeUpdate();
        }
    }
}
