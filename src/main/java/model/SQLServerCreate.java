package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static model.SQLConnection.connection;

public class SQLServerCreate {

    public static void createDb(String currencyAlternateKey, String currencyName) throws SQLException, ClassNotFoundException {

        try {

            String query = "INSERT INTO DimCurrency (CurrencyAlternateKey, CurrencyName) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, currencyAlternateKey);
            preparedStatement.setString(2, currencyName);

            // Execute the insert
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}