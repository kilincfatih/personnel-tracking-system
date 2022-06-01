/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author USER
 */
public class DepartmanBilgileri {
    
    private int id;
    private String tc;
    private String calistigiDepartman;
    private String meslek;
    private String zimmetliEsyalar;
    private String iseBaslamaTarihi;

    public DepartmanBilgileri(int id, String tc, String calistigiDepartman, String meslek, String zimmetliEsyalar, String iseBaslamaTarihi) {
        this.id = id;
        this.tc = tc;
        this.calistigiDepartman = calistigiDepartman;
        this.meslek = meslek;
        this.zimmetliEsyalar = zimmetliEsyalar;
        this.iseBaslamaTarihi = iseBaslamaTarihi;
    }

    public DepartmanBilgileri() {
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

    public String getCalistigiDepartman() {
        return calistigiDepartman;
    }

    public void setCalistigiDepartman(String calistigiDepartman) {
        this.calistigiDepartman = calistigiDepartman;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    public String getZimmetliEsyalar() {
        return zimmetliEsyalar;
    }

    public void setZimmetliEsyalar(String zimmetliEsyalar) {
        this.zimmetliEsyalar = zimmetliEsyalar;
    }

    public String getIseBaslamaTarihi() {
        return iseBaslamaTarihi;
    }

    public void setIseBaslamaTarihi(String iseBaslamaTarihi) {
        this.iseBaslamaTarihi = iseBaslamaTarihi;
    }

   
}
