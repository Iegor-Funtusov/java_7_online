package ua.com.alevel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcConfig {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/java_7";
    private final String username = "root";
    private final String password = "Test123!";

    private Connection connection;
    private Statement statement;

    private static final JdbcConfig instance = new JdbcConfig();

    private JdbcConfig() {
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, username, password);
            this.statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("e = " + e);
        }
    }

    public static JdbcConfig getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
