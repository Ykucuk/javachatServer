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
import content.Mesaj;
import java.net.Socket;
import java.io.*;

public class Istemci extends Thread {

    Socket mijnSock;

    ObjectInputStream ois;
    ObjectOutputStream oos;

    Boolean GirisDurumu = false;

    Mesaj GelenMesaj = null;
    Mesaj GidenMesaj = null;

    public Istemci(Socket mijnSock) {
        this.mijnSock = mijnSock;
        try {
            oos = new ObjectOutputStream(this.mijnSock.getOutputStream());
            ois = new ObjectInputStream(this.mijnSock.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("calistim.");
        try {
            while (true) {

                GelenMesaj = (Mesaj) ois.readObject();

                if (GelenMesaj.getTur().equals("/giris")) {
                    GidenMesaj = new Mesaj();
                    GidenMesaj.setTur("/global");
                    GidenMesaj.setMesaj("giris yapiliyor. Lutfen bekleyiniz.");
                    Ilet();
                    if (Veritabani.KullaniciGiris(GelenMesaj.getHesap_adi(), GelenMesaj.getHesap_sifre())) {
                        if (!Veritabani.KullaniciDurumu(GelenMesaj.getHesap_adi())) {
                            Veritabani.KullaniciDurumuAktif(GelenMesaj.getHesap_adi());
                            GidenMesaj = new Mesaj();
                            GidenMesaj.setTur("/girisyap");
                            GidenMesaj.setMesaj("giris yapildi.");
                            Ilet();
                        } else {
                            GidenMesaj = new Mesaj();
                            GidenMesaj.setTur("/global");
                            GidenMesaj.setMesaj("oturum zaten aciktir..");
                            Ilet();
                        }
                    } else {
                        GidenMesaj = new Mesaj();
                        GidenMesaj.setTur("/global");
                        GidenMesaj.setMesaj("giris yapilamadi.");
                        Ilet();
                    }
                } else if (GelenMesaj.getTur().equals("/global")) {
                    System.out.println(GelenMesaj.getMesaj());
                }

            }
        } catch (Exception e) {
            System.err.println("baglanti kapatildi.");
        }
    }

    public void Ilet() {
        try {
            oos.writeObject(GidenMesaj);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Giris() {
        GirisDurumu = true;
    }

}
