import java.sql.SQLException;
import java.util.Scanner;

import static model.SQLConnection.connectDb;
import static model.SQLConnection.disconnectDb;
import static model.SQLServerCreate.createDb;
import static model.SQLServerSearch.connect;
import static model.SQLServerDelete.deleteDb;
import static model.SQLServerUpdate.updateDb;


public class DatabaseCrud {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        String currencyAlternateKey;
        String currencyName;
        String newCurrencyAlternateKey;
        String oldCurrencyAlternateKey;
        connectDb();
        System.out.println("DimCurrency veritabanında işlem yapıyorsunuz işleminizi seçiniz.");
        System.out.println("Arama yapmak için ara , yeni oluşturmak için ekle ," +
                " silmek için sil  , güncellemek için güncelle yazınız.");
        String islem=scanner.nextLine();
        switch (islem.toUpperCase()){
            case "ARA":
                System.out.println("Arama yapmak istediğiniz para birimini giriniz:");
                currencyAlternateKey=scanner.nextLine();
                connect(currencyAlternateKey);
                break;
            case "EKLE":
                System.out.println("Eklemek istediğiniz para biriminin önce kısaltmasını sonra tam adını giriniz.");
                System.out.println("Kısaltması: ");
                currencyAlternateKey = scanner.nextLine();
                System.out.println("Tam ismi: ");
                currencyName = scanner.nextLine();
                try {
                    createDb(currencyAlternateKey, currencyName);
                } catch (SQLException e) {
                    System.out.println("Ekleme başarısız oldu , hata:"+e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Ekleme başarısız oldu , hata:"+e);
                break;
                }
                break;
            case "SİL":
                System.out.println("Önce arama yaparak silmek istediğiniz para biriminin kısaltmasını seçiniz:");
                currencyAlternateKey=scanner.nextLine();
                connect(currencyAlternateKey);
                System.out.println("Silmek istediğiniz para biriminin kısaltmasını seçiniz.");
                currencyAlternateKey=scanner.nextLine();
                deleteDb(currencyAlternateKey);
                break;
            case "GÜNCELLE":
                System.out.println("Önce arama yaparak güncellemek istediğiniz para biriminin kısaltmasını seçiniz:");
                currencyAlternateKey=scanner.nextLine();
                connect(currencyAlternateKey);
                System.out.println("Güncellemek istediğiniz para biriminin kısaltmasını seçiniz.");
                oldCurrencyAlternateKey=scanner.nextLine();
                System.out.println("Güncellemek istediğiniz para biriminin yeni kısaltmasını seçiniz.");
                newCurrencyAlternateKey=scanner.nextLine();
                System.out.println("Güncellemek istediğiniz para biriminin yeni adını seçiniz.");
                currencyName=scanner.nextLine();

                updateDb(oldCurrencyAlternateKey,currencyName,newCurrencyAlternateKey);

                break;

        }
        disconnectDb();
    }
}
