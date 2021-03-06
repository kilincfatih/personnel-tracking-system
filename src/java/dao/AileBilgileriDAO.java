package dao;

import entity.AileBilgileri;
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
public class AileBilgileriDAO extends DBConnection {

    public void create(AileBilgileri k) {

        try {
            Statement st = this.connect().createStatement();
            String query = "insert into aile_bilgileri (aile_bilgiler_tc, yakinin_adi_soyadi, aile_yakinligi, iletisim_no) values ('" + k.getKbTc() + "', '" + k.getAdSoyad() + "', '" + k.getAileYakinligi() + "', '" + k.getIletisimNo() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(AileBilgileri k) {

        try {
            Statement st = this.connect().createStatement();
            String query = "update aile_bilgileri set aile_bilgiler_tc='" + k.getKbTc() + "', yakinin_adi_soyadi='" + k.getAdSoyad() + "', aile_yakinligi='" + k.getAileYakinligi() + "', iletisim_no='" + k.getIletisimNo() + "'  where id=" + k.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(AileBilgileri k) {

        try {
            Statement st = this.connect().createStatement();
            String query = "delete from aile_bilgileri where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<AileBilgileri> getList() {
        List<AileBilgileri> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from aile_bilgileri order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new AileBilgileri(rs.getInt("id"), rs.getString("aile_bilgiler_tc"), rs.getString("yakinin_adi_soyadi"), rs.getString("aile_yakinligi"), rs.getString("iletisim_no")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
