package dao;

import entity.IletisimBilgileri;
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
public class IletisimBilgileriDAO extends DBConnection {

    public void create(IletisimBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into iletisim_bilgileri (iletisim_bilgiler_tc, telefon_no, mail_adresi, posta_kodu) values ('" + k.getTc() + "', '" + k.getTelefonNo() + "', '" + k.getMailAdresi() + "', '" + k.getPostaKodu() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    public void update(IletisimBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update iletisim_bilgileri set iletisim_bilgiler_tc ='" + k.getTc() + "', telefon_no='" + k.getTelefonNo() + "', mail_adresi='" + k.getMailAdresi() + "', posta_kodu='" + k.getPostaKodu() + "' where id=" + k.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(IletisimBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "delete from iletisim_bilgileri where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<IletisimBilgileri> getList() {
        List<IletisimBilgileri> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from iletisim_bilgileri order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new IletisimBilgileri(rs.getInt("id"), rs.getString("iletisim_bilgiler_tc"), rs.getString("telefon_no"), rs.getString("mail_adresi"), rs.getString("posta_kodu")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
