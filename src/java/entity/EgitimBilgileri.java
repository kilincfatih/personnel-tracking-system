/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author USER
 */
public class EgitimBilgileri {
    private int id;
    private String tc;
    private String ortaokul;
    private String lise;
    private String universite;
    private String yabanciDil;

    public EgitimBilgileri(int id, String tc, String ortaokul, String lise, String universite, String yabanciDil) {
        this.id = id;
        this.tc = tc;
        this.ortaokul = ortaokul;
        this.lise = lise;
        this.universite = universite;
        this.yabanciDil = yabanciDil;
    }

    public EgitimBilgileri() {
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

    public String getOrtaokul() {
        return ortaokul;
    }

    public void setOrtaokul(String ortaokul) {
        this.ortaokul = ortaokul;
    }

    public String getLise() {
        return lise;
    }

    public void setLise(String lise) {
        this.lise = lise;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getYabanciDil() {
        return yabanciDil;
    }

    public void setYabanciDil(String yabanciDil) {
        this.yabanciDil = yabanciDil;
    }

  
}
