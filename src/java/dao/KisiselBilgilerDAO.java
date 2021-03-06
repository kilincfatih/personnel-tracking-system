package dao;

import entity.KisiselBilgiler;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taha Kubilay ÖZDOĞAN - 02205076007
 * @author Fatih KILINÇ - 02205076006
 * @author Eren ALPARSLAN - 02205076019
 */
public class KisiselBilgilerDAO extends DBConnection {
   
    public void create(KisiselBilgiler k) {

        try {
            Statement st = this.connect().createStatement();
            String query = "insert into kisisel_bilgiler (tc, ad_soyad, dogum_tarihi, medeni_hali) values ('" + k.getTc() + "', '" + k.getAdSoyad() + "', '" + k.getDogumTarihi() + "', '" + k.getMedeniHali() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(KisiselBilgiler k) {

        try {
            Statement st = this.connect().createStatement();
            String query = "update kisisel_bilgiler set tc ='" + k.getTc() + "', ad_soyad='" + k.getAdSoyad() + "', dogum_tarihi='" + k.getDogumTarihi() + "', medeni_hali='" + k.getMedeniHali() + "'  where id=" + k.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(KisiselBilgiler k) {

        try {
            Statement st = this.connect().createStatement();
            String query = "delete from kisisel_bilgiler where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<KisiselBilgiler> getList() {
        List<KisiselBilgiler> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from kisisel_bilgiler order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new KisiselBilgiler(rs.getInt("id"), rs.getString("tc"), rs.getString("ad_soyad"), rs.getString("dogum_tarihi"), rs.getString("medeni_hali")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
