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
import icerik.Icerik;
import icerik.Mesaj;
import icerik.Giris;
import icerik.Durum;
import java.net.Socket;
import java.io.*;

public class Istemci extends Thread {

    Socket mijnSock;
    Sunucu mijnSunucu;
    
    ObjectInputStream ois;
    ObjectOutputStream oos;

    Boolean GirisDurumu = false;

    Icerik GelenIcerik = null;
    Icerik GidenIcerik = null;

    Mesaj mesaj;
    Durum durum;

    public Istemci(Socket mijnSock, Sunucu s) {
        this.mijnSock = mijnSock;
        this.mijnSunucu = s;
        try {
            oos = new ObjectOutputStream(this.mijnSock.getOutputStream());
            ois = new ObjectInputStream(this.mijnSock.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {

                this.GelenIcerik = (Icerik) ois.readObject();

                if (this.GelenIcerik.getTur() == 'G') {

                    Giris login = (Giris) this.GelenIcerik;

                    if (Veritabani.KullaniciBul(login.getHesapAdi()) && Veritabani.KullaniciGiris(login.getHesapAdi(), login.getHesapSifre())) {

                        if (!Veritabani.KullaniciDurumu(login.getHesapAdi())) {
                            Veritabani.KullaniciDurumuAktif(login.getHesapAdi());

                            this.durum = new Durum();
                            this.durum.setTur('D');
                            this.durum.setDurumTur('G');
                            this.durum.setGirisDurumu(true);
                            this.durum.setDurumBilgisi("Giris islemi yapildi. lutfen bekleyiniz.");
                            this.Ilet(this.durum);

                        } else {
                            this.mesaj = new Mesaj();
                            this.mesaj.setTur('M');
                            this.mesaj.setMesaj("Giris yapilamadi. Hesap zaten aktif gorunuyor. Yonetici ile iletisime geciniz!");
                            this.Ilet(this.mesaj);
                        }

                    } else {
                        this.mesaj = new Mesaj();
                        this.mesaj.setTur('M');
                        this.mesaj.setMesaj("Giris yapilamadi. Hesap adiniz bulunamadi yada hatali bilgi girisinde bulundunuz.");
                        this.Ilet(this.mesaj);

                    }

                } else if (this.GelenIcerik.getTur() == 'M') {
                    Mesaj msj = (Mesaj) this.GelenIcerik;
                    System.out.println("Test islemi istendi.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            mijnSunucu.KullaniciCikar(this);
            System.err.println("baglanti kapatildi.");
        }
    }

    public void Ilet(Icerik gidenicerik) {
        try {
            oos.writeObject(gidenicerik);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Giris() {
        GirisDurumu = true;
    }

}
