package model;
import java.sql.*;

import static model.SQLConnection.connection;

//database bağlantı*
public class SQLServerSearch {

    public static void connect(String currencyAlternateKey){



        try {

            // SQL sorgusu - LIKE operatörü kullanarak benzer sonuçları arar
            String query = "SELECT * FROM DimCurrency WHERE CurrencyAlternateKey LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Kullanıcı girdisiyle eşleşen tüm değerleri bulmak için '%currencyAlternateKey%' kullanılır.
            preparedStatement.setString(1, currencyAlternateKey + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            // Sonuçları yazdır
            while (resultSet.next()) {
                System.out.println("****Para Birimi****");
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Kısaltması: " + resultSet.getString(2));
                System.out.println("Tam ismi: " + resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
