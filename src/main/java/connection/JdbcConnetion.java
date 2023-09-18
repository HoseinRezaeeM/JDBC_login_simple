package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnetion {

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "173725Hrm");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JdbcConnetion() throws SQLException {
    }

    public Connection getConnection() {
        return connection;
    }
}
