package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    static Connection connection = null;
    static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorksDW2022;encrypt=true;trustServerCertificate=true;";
    static String user = "Tolga_sa";
    static String pass = "admin";

    public static void connectDb(){
        try {
            // Sürücüyü yükle
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Bağlantı başarılı!");
    } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void disconnectDb(){
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
