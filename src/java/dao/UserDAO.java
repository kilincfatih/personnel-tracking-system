package dao;

import entity.SystemGroup;
import entity.SystemUser;
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
public class UserDAO extends DBConnection {

    private GroupDAO gdao;

    public void create(SystemUser k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into systemuser (email, pass, ugroup) values ('" + k.getEmail() + "', '" + k.getPass() + "', '" + k.getGroup().getId() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(SystemUser k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update systemuser set pass='" + k.getPass() + "', ugroup='" + k.getGroup().getId() + "' where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(SystemUser k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "delete from systemuser where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<SystemUser> getList() {
        List<SystemUser> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from systemuser order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                SystemGroup g = this.getGdao().getById(rs.getLong("ugroup"));
                list.add(new SystemUser(rs.getLong("id"), rs.getString("email"), rs.getString("pass"), g));
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

}
