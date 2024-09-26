package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static model.SQLConnection.connection;

public class SQLServerUpdate {
    public static void updateDb(String oldCurrencyAlternateKey, String currencyName,String newCurrencyAlternateKey) throws SQLException, ClassNotFoundException {


        try {
            String query = "UPDATE DimCurrency SET CurrencyAlternateKey = ?, CurrencyName = ? WHERE CurrencyAlternateKey = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newCurrencyAlternateKey); // Yeni CurrencyAlternateKey değeri
            preparedStatement.setString(2, currencyName); // Güncellenmek istenen CurrencyName değeri
            preparedStatement.setString(3, oldCurrencyAlternateKey); // Hangi CurrencyAlternateKey değeri güncellenecek

// Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    }
