package dao;

import entity.EgitimBilgileri;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Taha Kubilay ÖZDOĞAN - 02205076007
 * @author Fatih KILINÇ - 02205076006
 * @author Eren ALPARSLAN - 02205076019
 */
public class EgitimBilgileriDAO extends DBConnection {

    public void create(EgitimBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into egitim_bilgileri (egitim_biligiler_tc, ortaokul, lise, universite, yabanci_dil) values ('" + k.getTc() + "', '" + k.getOrtaokul() + "', '" + k.getLise() + "', '" + k.getUniversite() + "' , '" + k.getYabanciDil() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public EgitimBilgileri findByID(int id) {
        EgitimBilgileri k = null;
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from egitim_bilgileri where id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                k = new EgitimBilgileri(rs.getInt("id"), rs.getString("egitim_bilgiler_tc"), rs.getString("ortaokul"), rs.getString("lise"), rs.getString("universite"), rs.getString("yabanci_dil"));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return k;
    }

    public void update(EgitimBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update egitim_bilgileri set egitim_bilgiler_tc ='" + k.getTc() + "', ortaokul='" + k.getOrtaokul() + "', lise='" + k.getLise() + "', universite='" + k.getUniversite() + "', yabanci_dil='" + k.getYabanciDil() + "' where id=" + k.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(EgitimBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "delete from egitim_bilgileri where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<EgitimBilgileri> getList() {
        List<EgitimBilgileri> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from egitim_bilgileri order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new EgitimBilgileri(rs.getInt("id"), rs.getString("egitim_bilgiler_tc"), rs.getString("ortaokul"), rs.getString("lise"), rs.getString("universite"), rs.getString("yabanci_dil")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
