/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Taha Kubilay ÖZDOĞAN - 02205076007
 * @author Fatih KILINÇ - 02205076006
 * @author Eren ALPARSLAN - 02205076019
 */

public class KisiselBilgiler {

    private int id;
    private String tc;
    private String isim;
    private String soyIsim;

    public int getId() {
        return id;
    }

    public KisiselBilgiler(String tc, String isim, String soyIsim) {
        this.tc = tc;
        this.isim = isim;
        this.soyIsim = soyIsim;
    }

    public KisiselBilgiler(int id, String tc, String isim, String soyIsim) {
        this.id = id;
        this.tc = tc;
        this.isim = isim;
        this.soyIsim = soyIsim;
    }

    public KisiselBilgiler() {
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

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }
    
}
