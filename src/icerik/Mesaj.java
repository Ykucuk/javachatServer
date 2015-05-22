/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icerik;

/**
 *
 * @author Yasin
 */
public class Mesaj extends Icerik {
    
    private String Mesaj;

    public Mesaj() {
        setTur(SunucuKomut._MESAJ);
    }
    
    
    /**
     * @return the Mesaj
     */
    public String getMesaj() {
        return Mesaj;
    }

    /**
     * @param Mesaj the Mesaj to set
     */
    public void setMesaj(String Mesaj) {
        this.Mesaj = Mesaj;
    }
}
