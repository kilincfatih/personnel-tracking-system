package dao;

import entity.DepartmanBilgileri;
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
public class DepartmanBilgileriDAO extends DBConnection {

    public void create(DepartmanBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into departman_bilgileri (departman_bilgiler_tc, calistigi_departman, meslek, zimmetli_esyalar, ise_baslama_tarihi) values ('" + k.getTc() + "', '" + k.getCalistigiDepartman() + "', '" + k.getMeslek() + "', '" + k.getZimmetliEsyalar() + "' , '" + k.getIseBaslamaTarihi() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public DepartmanBilgileri findByID(int id) {
        DepartmanBilgileri k = null;
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from departman_bilgileri where id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                k = new DepartmanBilgileri(rs.getInt("id"), rs.getString("departman_bilgiler_tc"), rs.getString("calistigi_departman"), rs.getString("meslek"), rs.getString("zimmetli_esyalar"), rs.getString("ise_baslama_tarihi"));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return k;
    }

    public void update(DepartmanBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update departman_bilgileri set departman_bilgiler_tc ='" + k.getTc() + "', calistigi_departman='" + k.getCalistigiDepartman() + "', meslek='" + k.getMeslek() + "', zimmetli_esyalar='" + k.getZimmetliEsyalar() + "', ise_baslama_tarihi='" + k.getIseBaslamaTarihi() + "' where id=" + k.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(DepartmanBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "delete from departman_bilgileri where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<DepartmanBilgileri> getList() {
        List<DepartmanBilgileri> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from departman_bilgileri order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new DepartmanBilgileri(rs.getInt("id"), rs.getString("departman_bilgiler_tc"), rs.getString("calistigi_departman"), rs.getString("meslek"), rs.getString("zimmetli_esyalar"), rs.getString("ise_baslama_tarihi")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
