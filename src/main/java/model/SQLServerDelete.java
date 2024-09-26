package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static model.SQLConnection.connection;

public class SQLServerDelete {


        public static void deleteDb(String currencyAlternateKey) throws SQLException, ClassNotFoundException {

            try {


                String query = "DELETE FROM DimCurrency WHERE CurrencyAlternateKey = ?;";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, currencyAlternateKey);


                // Execute the insert
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

