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
    private String adSoyad;
    private String dogumTarihi;
    private String medeniHali;

    public KisiselBilgiler(int id, String tc, String adSoyad, String dogumTarihi, String medeniHali) {
        this.id = id;
        this.tc = tc;
        this.adSoyad = adSoyad;
        this.dogumTarihi = dogumTarihi;
        this.medeniHali = medeniHali;
    }

    public KisiselBilgiler(String tc, String adSoyad, String dogumTarihi, String medeniHali) {
        this.tc = tc;
        this.adSoyad = adSoyad;
        this.dogumTarihi = dogumTarihi;
        this.medeniHali = medeniHali;
    }

    public KisiselBilgiler() {
    }

    public KisiselBilgiler(String adSoyad) {
        this.adSoyad = adSoyad;
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

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getMedeniHali() {
        return medeniHali;
    }

    public void setMedeniHali(String medeniHali) {
        this.medeniHali = medeniHali;
    }

}
