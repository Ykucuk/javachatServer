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
import icerik.KullaniciBilgileri;
import gui.mainWindow;
import java.sql.*;
import javax.swing.JOptionPane;

public class Veritabani {

    public static Connection baglanti;
    public static PreparedStatement sorgu;
    public static String query;
    public static ResultSet sonuc;
    public static boolean durum;

    private mainWindow mainWindow = null;

    String isim = "root";
    String sifre = "";
    String adres = "jdbc:mysql://localhost:3306/bilgiagi";

    public Veritabani(mainWindow ml) {
        try {
            this.mainWindow = ml;
            Class.forName("com.mysql.jdbc.Driver");
            baglanti = DriverManager.getConnection(adres, isim, sifre);
            this.mainWindow.OutputAdd("Veritabani baglantisi basarili bir sekilde saglandi.");
            durum = true;
        } catch (Exception e) {
            this.mainWindow.OutputAdd("Veritabani baglantisi basarisiz !");
            System.err.println(e.getMessage());
        }
    }

    public static void DurumKontrol() {

    }

    public static void YeniHesapOlustur(KullaniciBilgileri ref) {
        try {
            query = "INSERT INTO hesap (isim, soyisim, telefon, telefon2, email,"
                    + "ulke, sehir, adress,"
                    + "hesapAdi, hesapSifre, hesapOlusturmaTarihi, hesapDurum, hesapRutbe,"
                    + "hesapEmail, hesapID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            sorgu = baglanti.prepareStatement(query);

            sorgu.setString(1, ref.getIsim());
            sorgu.setString(2, ref.getSoyisim());
            sorgu.setString(3, ref.getTelefon());
            sorgu.setString(4, ref.getTelefon2());

            sorgu.setString(5, ref.getEmail());
            sorgu.setString(6, ref.getUlke());
            sorgu.setString(7, ref.getSehir());
            sorgu.setString(8, ref.getAdress());

            sorgu.setString(9, ref.getHesapAdi());
            sorgu.setString(10, ref.getHesapSifre());
            sorgu.setString(11, ref.getHesapOlusturmaTarih());
            sorgu.setString(12, ref.getHesapDurum());
            sorgu.setString(13, ref.getHesapRutbe());
            sorgu.setString(14, ref.getHesapEmail());
            sorgu.setString(15, ref.getHesapID());

            sorgu.execute();
            JOptionPane.showMessageDialog(null, "hesap olusturma islemi basari ile gerceklesti..", "Oldu!", JOptionPane.INFORMATION_MESSAGE);

            sorgu.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean KullaniciGiris(String isim, String sifre) {
        try {
            query = "SELECT hesapAdi, hesapSifre FROM hesap WHERE hesapAdi = ? AND hesapSifre = ?";
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
            query = "SELECT hesapDurum FROM hesap WHERE hesapAdi = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, isim);
            sonuc = sorgu.executeQuery();
            sonuc.next();
            if (sonuc.getInt("hesapDurum") == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public static void KullaniciDurumuAktif(String isim) {
        try {
            System.out.println("hesap sistem aktif olarak islenmistir.." + isim);
            query = "UPDATE hesap SET hesapDurum = '1'  WHERE hesapAdi = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, isim);
            sorgu.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void KullaniciDurumuDeAktif(String isim) {
        try {

            query = "UPDATE hesap SET hesapDurum = '0'  WHERE hesapAdi = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, isim);
            sorgu.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static boolean KullaniciBul(String isim) {
        try {
            query = "SELECT hesapAdi FROM hesap WHERE hesapAdi = ?";
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

    public static KullaniciBilgileri KullaniciBilgileriBul(String isim) {
        try {

            query = "SELECT * FROM hesap WHERE hesapAdi = ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, isim);
            sonuc = sorgu.executeQuery();
            sonuc.next();

            KullaniciBilgileri kullaniciBilgileriSinif = new KullaniciBilgileri();
            kullaniciBilgileriSinif.setSonuc(sonuc);
            return kullaniciBilgileriSinif;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String[] KullaniciArama(String ara) {
        String[] sonuclar = new String[15];
        int sira = 0;
        try {
            query = "SELECT * FROM hesap WHERE hesapAdi LIKE ?";
            sorgu = baglanti.prepareStatement(query);
            sorgu.setString(1, "%" + ara + "%");
            sonuc = sorgu.executeQuery();
            while(sonuc.next()) {
                sonuclar[sira] = sonuc.getString("hesapAdi");
                System.out.println(sira + " " + sonuc.getString("hesapAdi"));
                sira++;
            }
            
            return sonuclar;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
