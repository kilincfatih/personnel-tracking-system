package dao;

import entity.Privileges;
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
public class PrivilegesDAO extends DBConnection {

    public void create(Privileges k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into privileges (mname, icreate, iread, iupdate, idelete, ilist, ishow) values ('" + k.getMname() + "', '" + k.isIcreate() + "', '" + k.isIread() + "', '" + k.isIupdate() + "', '" + k.isIdelete() + "', '" + k.isIlist() + "', '" + k.isIrshow() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Privileges k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update privileges set mname ='" + k.getMname() + "', icreate='" + k.isIcreate() + "', iread='" + k.isIread() + "', iupdate='" + k.isIupdate() + "', idelete='" + k.isIdelete() + "', ilist='" + k.isIlist() + "', ishow='" + k.isIrshow() + "'  where id=" + k.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Privileges k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "delete from privileges where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Privileges> getList() {
        List<Privileges> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from privileges order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Privileges(rs.getInt("id"), rs.getString("tc"), rs.getString("ad_soyad"), rs.getString("dogum_tarihi"), rs.getString("medeni_hali")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
