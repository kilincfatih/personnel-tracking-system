/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author USER
 */
public class IletisimBilgileri {
    private int id;
    private String tc;
    private String telefonNo;
    private String mailAdresi;
    private String postaKodu;

    public IletisimBilgileri(int id, String tc, String telefonNo, String mailAdresi, String postaKodu) {
        this.id = id;
        this.tc = tc;
        this.telefonNo = telefonNo;
        this.mailAdresi = mailAdresi;
        this.postaKodu = postaKodu;
    }

    public IletisimBilgileri() {
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

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getMailAdresi() {
        return mailAdresi;
    }

    public void setMailAdresi(String mailAdresi) {
        this.mailAdresi = mailAdresi;
    }

    public String getPostaKodu() {
        return postaKodu;
    }

    public void setPostaKodu(String postaKodu) {
        this.postaKodu = postaKodu;
    }

   
}
