package logic.persistence;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static final String JDBC_CONNECTION_URL =
            "jdbc:mysql://localhost:3306/test1"; 

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        try {
            Object o = Class.forName("com.mysql.jdbc.Driver"); 
            o.getClass();
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(JDBC_CONNECTION_URL, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

  public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            getConnection();
    }
}
