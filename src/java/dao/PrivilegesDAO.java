package dao;

import entity.Privileges;
import entity.SystemGroup;
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

    private GroupDAO gdao;

    public void create(Privileges k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into privileges (sgroup, mname, icreate, iread, iupdate, idelete, ilist, ishow) values ('" + k.getPgroup().getId() + "', '" + k.getMname() + "', '" + k.isIcreate() + "', '" + k.isIread() + "', '" + k.isIupdate() + "', '" + k.isIdelete() + "', '" + k.isIlist() + "', '" + k.isIrshow() + "')";
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
                SystemGroup g = this.getGdao().getById(rs.getLong("sgroup"));
                list.add(new Privileges(rs.getLong("id"), g, rs.getString("mname"), rs.getBoolean("icreate"), rs.getBoolean("iread"), rs.getBoolean("iupdate"), rs.getBoolean("idelete"), rs.getBoolean("ilist"), rs.getBoolean("ishow")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public GroupDAO getGdao() {
        if (this.gdao == null) {
            this.gdao = new GroupDAO();
        }
        return gdao;
    }

    public void setGdao(GroupDAO gdao) {
        this.gdao = gdao;
    }

    public List<Privileges> getList(int page) {
        List<Privileges> list = new ArrayList<>();
        int offset = (page - 1) * 5;
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from privileges order by id asc limit 5 offset " + offset;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                SystemGroup g = this.getGdao().getById(rs.getLong("sgroup"));
                list.add(new Privileges(rs.getLong("id"), g, rs.getString("mname"), rs.getBoolean("icreate"), rs.getBoolean("iread"), rs.getBoolean("iupdate"), rs.getBoolean("idelete"), rs.getBoolean("ilist"), rs.getBoolean("ishow")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
