/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author USER
 */
public class BankaBilgileri {
    private int id;
    private String tc;
    private String adSoyad;
    private String hesapNo;
    private String iban;
    private String bankaAdi;
    private String subeAdi;
    private String subeKodu;

    public BankaBilgileri(int id, String tc, String adSoyad, String hesapNo, String iban, String bankaAdi, String subeAdi, String subeKodu) {
        this.id = id;
        this.tc = tc;
        this.adSoyad = adSoyad;
        this.hesapNo = hesapNo;
        this.iban = iban;
        this.bankaAdi = bankaAdi;
        this.subeAdi = subeAdi;
        this.subeKodu = subeKodu;
    }

    public BankaBilgileri() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(String hesapNo) {
        this.hesapNo = hesapNo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBankaAdi() {
        return bankaAdi;
    }

    public void setBankaAdi(String bankaAdi) {
        this.bankaAdi = bankaAdi;
    }

    public String getSubeAdi() {
        return subeAdi;
    }

    public void setSubeAdi(String subeAdi) {
        this.subeAdi = subeAdi;
    }

    public String getSubeKodu() {
        return subeKodu;
    }

    public void setSubeKodu(String subeKodu) {
        this.subeKodu = subeKodu;
    }

    
}
