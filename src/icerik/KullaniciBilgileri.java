/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icerik;

import java.sql.ResultSet;

/**
 *
 * @author Yasin
 */
public class KullaniciBilgileri {

    private String isim;
    private String soyisim;
    private String telefon;
    private String telefon2;
    private String email;
    private String ulke;
    private String sehir;
    private String adress;

    /* hesap */
    private String hesapAdi;
    private String hesapSifre;
    private String hesapOlusturmaTarih;
    private String hesapSonGiris;
    private String hesapDurum;
    private String hesapRutbe;
    private String hesapEmail;
    private String hesapID;
    
    
    private ResultSet sonuc;
    
    
    

    public void KullaniciBilgileriOku() {
        try {
            setIsim(sonuc.getString(2));
            setSoyisim(sonuc.getString(3));
            setTelefon(sonuc.getString(4));
            setTelefon2(sonuc.getString(5));

            setEmail(sonuc.getString(6));
            setUlke(sonuc.getString(7));
            setSehir(sonuc.getString(8));
            setAdress(sonuc.getString(9));

            setHesapAdi(sonuc.getString(10));
            setHesapSifre(sonuc.getString(11));
            setHesapOlusturmaTarih(sonuc.getString(12));
            setHesapSonGiris(sonuc.getString(13));
            setHesapDurum(sonuc.getString(14));
            setHesapRutbe(sonuc.getString(15));
            setHesapEmail(sonuc.getString(16));
            setHesapID(sonuc.getString(17));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the isim
     */
    public String getIsim() {
        return isim;
    }

    /**
     * @param isim the isim to set
     */
    public void setIsim(String isim) {
        this.isim = isim;
    }

    /**
     * @return the soyisim
     */
    public String getSoyisim() {
        return soyisim;
    }

    /**
     * @param soyisim the soyisim to set
     */
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * @return the telefon2
     */
    public String getTelefon2() {
        return telefon2;
    }

    /**
     * @param telefon2 the telefon2 to set
     */
    public void setTelefon2(String telefon2) {
        this.telefon2 = telefon2;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ulke
     */
    public String getUlke() {
        return ulke;
    }

    /**
     * @param ulke the ulke to set
     */
    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    /**
     * @return the sehir
     */
    public String getSehir() {
        return sehir;
    }

    /**
     * @param sehir the sehir to set
     */
    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the hesapAdi
     */
    public String getHesapAdi() {
        return hesapAdi;
    }

    /**
     * @param hesapAdi the hesapAdi to set
     */
    public void setHesapAdi(String hesapAdi) {
        this.hesapAdi = hesapAdi;
    }

    /**
     * @return the hesapSifre
     */
    public String getHesapSifre() {
        return hesapSifre;
    }

    /**
     * @param hesapSifre the hesapSifre to set
     */
    public void setHesapSifre(String hesapSifre) {
        this.hesapSifre = hesapSifre;
    }

    /**
     * @return the hesapOlusturmaTarih
     */
    public String getHesapOlusturmaTarih() {
        return hesapOlusturmaTarih;
    }

    /**
     * @param hesapOlusturmaTarih the hesapOlusturmaTarih to set
     */
    public void setHesapOlusturmaTarih(String hesapOlusturmaTarih) {
        this.hesapOlusturmaTarih = hesapOlusturmaTarih;
    }

    /**
     * @return the hesapSonGiris
     */
    public String getHesapSonGiris() {
        return hesapSonGiris;
    }

    /**
     * @param hesapSonGiris the hesapSonGiris to set
     */
    public void setHesapSonGiris(String hesapSonGiris) {
        this.hesapSonGiris = hesapSonGiris;
    }

    /**
     * @return the hesapDurum
     */
    public String getHesapDurum() {
        return hesapDurum;
    }

    /**
     * @param hesapDurum the hesapDurum to set
     */
    public void setHesapDurum(String hesapDurum) {
        this.hesapDurum = hesapDurum;
    }

    /**
     * @return the hesapRutbe
     */
    public String getHesapRutbe() {
        return hesapRutbe;
    }

    /**
     * @param hesapRutbe the hesapRutbe to set
     */
    public void setHesapRutbe(String hesapRutbe) {
        this.hesapRutbe = hesapRutbe;
    }

    /**
     * @return the hesapEmail
     */
    public String getHesapEmail() {
        return hesapEmail;
    }

    /**
     * @param hesapEmail the hesapEmail to set
     */
    public void setHesapEmail(String hesapEmail) {
        this.hesapEmail = hesapEmail;
    }

    /**
     * @return the hesapID
     */
    public String getHesapID() {
        return hesapID;
    }

    /**
     * @param hesapID the hesapID to set
     */
    public void setHesapID(String hesapID) {
        this.hesapID = hesapID;
    }

    /**
     * @return the sonuc
     */
    public ResultSet getSonuc() {
        return sonuc;
    }

    /**
     * @param sonuc the sonuc to set
     */
    public void setSonuc(ResultSet sonuc) {
        this.sonuc = sonuc;
    }

}
