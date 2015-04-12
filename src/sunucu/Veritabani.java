/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunucu;

/**
 *
 * @author Yasin
 */
import java.sql.*;

public class Veritabani {

    public static Connection baglanti;
    public static PreparedStatement sorgu;
    public static String query;
    public static ResultSet sonuc;
    public static boolean durum;

    String isim = "root";
    String sifre = "";
    String adres = "jdbc:mysql://localhost:3306/bilgiagi";

    public Veritabani() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            baglanti = DriverManager.getConnection(adres, isim, sifre);
            System.out.println("veritabani olusturuldu.");
            durum = true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void DurumKontrol() {

    }

    public static void YeniHesapOlustur(String isim, String sifre) {
        try {
            query = "INSERT INTO hesap (isim, sifre, rank) VALUES (?,?,?)";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, isim);
            sorgu.setString(2, sifre);
            sorgu.setString(3, "default");
            sorgu.execute();
            System.out.println("Basarili bir sekilde eklendi");

            sorgu.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean KullaniciGiris(String isim, String sifre) {
        try {
            query = "SELECT isim, sifre FROM hesap WHERE isim = ? AND sifre = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, isim);
            sorgu.setString(2, sifre);
            sonuc = sorgu.executeQuery();
            if (sonuc.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public static boolean KullaniciDurumu(String isim) {
        try {
            query = "SELECT aktif FROM hesap WHERE isim = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, isim);
            sonuc = sorgu.executeQuery();
            sonuc.next();
            if(sonuc.getBoolean("aktif")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public static void KullaniciDurumuAktif(String isim) {
        try {
            System.out.println("calistim..." + isim);
            query = "UPDATE hesap SET aktif = ?  WHERE isim = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setInt(1, 0);
            sorgu.setString(2, isim);
            sorgu.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void KullaniciDurumuDeAktif(String isim) {
        try {
            
            query = "UPDATE hesap SET aktif = ?  WHERE isim = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setInt(1, 1);
            sorgu.setString(2, isim);
            sorgu.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static boolean KullaniciBul(String isim) {
        try {
            query = "SELECT isim FROM hesap WHERE isim = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, isim);
            sonuc = sorgu.executeQuery();

            if (sonuc.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean GirisYap(String isim, String sifre) {
        return false;
    }

    public static void Kapat() {
        try {
            durum = false;
            baglanti.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
