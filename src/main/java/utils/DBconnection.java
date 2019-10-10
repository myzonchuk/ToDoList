package utils;

import java.sql.*;

public class DBconnection {

    private static final String url = "jdbc:mysql://localhost:3306/softserve?serverTimezone=Europe/Kiev&useSSL=false";
    private static final String login = "root";
    private static final String passwordDB = "93honda03";
    private static Connection connection = null;

    private DBconnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, login, passwordDB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

