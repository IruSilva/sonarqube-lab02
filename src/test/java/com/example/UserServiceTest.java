package com.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void findUser_shouldPrepareStatement_andExecuteQuery() throws Exception {
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(conn.prepareStatement("SELECT id, name FROM users WHERE name = ?")).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);

        UserService service = new UserService() {
            @Override
            protected Connection openConnection() {
                return conn;
            }
        };

        service.findUser("bob");

        verify(conn).prepareStatement("SELECT id, name FROM users WHERE name = ?");
        verify(ps).setString(1, "bob");
        verify(ps).executeQuery();
        verify(rs).close();
        verify(ps).close();
        verify(conn).close();
    }

    @Test
    void deleteUser_shouldPrepareStatement_andExecuteUpdate() throws Exception {
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);

        when(conn.prepareStatement("DELETE FROM users WHERE name = ?")).thenReturn(ps);
        when(ps.executeUpdate()).thenReturn(1);

        UserService service = new UserService() {
            @Override
            protected Connection openConnection() {
                return conn;
            }
        };

        service.deleteUser("bob");

        verify(conn).prepareStatement("DELETE FROM users WHERE name = ?");
        verify(ps).setString(1, "bob");
        verify(ps).executeUpdate();
        verify(ps).close();
        verify(conn).close();
    }

    @Test
    void findUser_shouldHandleNoRowsGracefully() throws Exception {
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(conn.prepareStatement("SELECT id, name FROM users WHERE name = ?")).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(false);

        UserService service = new UserService() {
            @Override
            protected Connection openConnection() {
                return conn;
            }
        };

        service.findUser("no-user");

        verify(ps).executeQuery();
        verify(rs).close();
        verify(ps).close();
        verify(conn).close();
    }
}
