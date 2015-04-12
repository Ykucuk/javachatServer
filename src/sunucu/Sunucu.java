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
    
    
    public Sunucu(mainWindow win) {
        try {
            mainWindow = win;
            Baslat();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void Kapat() {
        try {
            mainWindow.OutputAdd("Kapatilma islemleri gerceklestiriliyor.");
            baglantiDinleyici.stop();
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
    private void Baslat() {
        try {
            mainWindow.OutputAdd("Sunucu baslatma islemi gerceklesior.");
            SunucuSocket = new ServerSocket(port, 10);
            Istemciler = new ArrayList<>();
            mainWindow.OutputAdd("ServerSocket calistirildi.");
            DinlemeyeBasla();
            
        } catch (Exception e) {
        }
    }
    
    
    private void DinlemeyeBasla() {
        baglantiDinleyici = new Thread() {

            @Override
            public void run() {
                mainWindow.OutputAdd("Dinleyici calistirildi.");
                try {
                    while(true) {
                        System.out.println("Kullanici bekleniyor.");
                        GelenBaglantiTmp = SunucuSocket.accept();
                        System.out.println("Kullanici kabul edildi.");
                        mainWindow.OutputAdd("Bir baglanti saglandi.. " + GelenBaglantiTmp.getInetAddress());
                        TmpIstemci =  new Istemci(GelenBaglantiTmp);
                        Istemciler.add(TmpIstemci);
                        TmpIstemci.start();
                        
                        
                    }
                } catch (Exception e) {
                    mainWindow.OutputAdd(e.getMessage());
                }
            }
        };
        
        baglantiDinleyici.start();
    }
    
    public void YenidenBaslat() {
        try {
            mainWindow.OutputAdd("Yeniden baslatma calistiriliyor.");
        } catch (Exception e) {
        }
    }
    
}
