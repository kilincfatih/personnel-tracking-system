package entity;

/**
 *
 * @author Taha Kubilay ÖZDOĞAN - 02205076007
 * @author Fatih KILINÇ - 02205076006
 * @author Eren ALPARSLAN - 02205076019
 */
public class AileBilgileri {

    private int id;
    private String kbTc;
    private String adSoyad;
    private String aileYakinligi;
    private String iletisimNo;

    public AileBilgileri(int id, String kbTc, String adSoyad, String aileYakinligi, String iletisimNo) {
        this.id = id;
        this.kbTc = kbTc;
        this.adSoyad = adSoyad;
        this.aileYakinligi = aileYakinligi;
        this.iletisimNo = iletisimNo;
    }

    public AileBilgileri() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKbTc() {
        return kbTc;
    }

    public void setKbTc(String kbTc) {
        this.kbTc = kbTc;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getAileYakinligi() {
        return aileYakinligi;
    }

    public void setAileYakinligi(String aileYakinligi) {
        this.aileYakinligi = aileYakinligi;
    }

    public String getIletisimNo() {
        return iletisimNo;
    }

    public void setIletisimNo(String iletisimNo) {
        this.iletisimNo = iletisimNo;
    }
    
}
