package sunucu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yasin
 */
import gui.mainWindow;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sunucu {

    private String ip = "";
    private int port = 1234;
    private String sunucuIsmi = "";

    ServerSocket SunucuSocket = null;
    Socket GelenBaglantiTmp = null;
    ArrayList<Istemci> Istemciler = null;
    Boolean sunucuDurumu = null;
    mainWindow mainWindow = null;
    Istemci TmpIstemci;
    Thread baglantiDinleyici;
    private int maxKullanici;

    public Sunucu(mainWindow win) {
        try {
            mainWindow = win;
            //Baslat();
        } catch (Exception e) {
            mainWindow.OutputAdd(e.getMessage());
        }
    }

    public void Kapat() {
        try {
            mainWindow.OutputAdd("Kapatilma islemleri gerceklestiriliyor.");
            baglantiDinleyici.stop();
            baglantiDinleyici = null;
            mainWindow.OutputAdd("Dinleyici durduruldu.");
            SunucuSocket.close();
            SunucuSocket = null;
            mainWindow.OutputAdd("Sunucu socket basari ile kapatildi.");
            GelenBaglantiTmp.close();
            GelenBaglantiTmp = null;
            mainWindow.OutputAdd("Gecici istemci sifirlandi.");
            Istemciler.removeAll(Istemciler);
            Istemciler = null;
            mainWindow.OutputAdd("Tum istemciler sonlandirildi ve istemci listesi kapatildi.");
            sunucuDurumu = false;
        } catch (Exception e) {
            mainWindow.OutputAdd(e.getMessage());
        }
    }

    public void Baslat() {
        try {
            mainWindow.OutputAdd("Sunucu olusturuluyor.");
            SunucuSocket = new ServerSocket(getPort(), this.getMaxKullanici());
            Istemciler = new ArrayList<>();
            mainWindow.OutputAdd("Sunucu olusturuldu.");
            DinlemeyeBasla();

        } catch (Exception e) {
        }
    }

    public void KullaniciCikar(Istemci arg) {
        try {
            this.Istemciler.remove(arg);
            this.mainWindow.jProgesbar1Guncelle(this.Istemciler.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DinlemeyeBasla() {
        baglantiDinleyici = new Thread() {

            @Override
            public void run() {
                mainWindow.OutputAdd("Baglanti dinleyici calistirildi.");
                try {
                    while (true) {
                        mainWindow.OutputAdd("Kullanici bekleniyor.");
                        GelenBaglantiTmp = SunucuSocket.accept();
                        mainWindow.OutputAdd("Kullanici kabul edildi.");
                        mainWindow.OutputAdd("Bir baglanti saglandi.. " + GelenBaglantiTmp.getInetAddress());
                        TmpIstemci = new Istemci(GelenBaglantiTmp, Sunucu.this);
                        Istemciler.add(TmpIstemci);

                        mainWindow.jProgesbar1Guncelle(Istemciler.size());
                        TmpIstemci.start();
                        TmpIstemci = null;

                    }
                } catch (Exception e) {
                    mainWindow.OutputAdd(e.getMessage());
                }
            }
        };

        baglantiDinleyici.start();
    }

    /**
     * @return the maxKullanici
     */
    public int getMaxKullanici() {
        return maxKullanici;
    }

    /**
     * @param maxKullanici the maxKullanici to set
     */
    public void setMaxKullanici(int maxKullanici) {
        this.maxKullanici = maxKullanici;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        try {
            this.ip = java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Sunucu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the sunucuIsmi
     */
    public String getSunucuIsmi() {
        return sunucuIsmi;
    }

    /**
     * @param sunucuIsmi the sunucuIsmi to set
     */
    public void setSunucuIsmi(String sunucuIsmi) {
        this.sunucuIsmi = sunucuIsmi;
    }

}
