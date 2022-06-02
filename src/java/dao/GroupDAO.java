package dao;

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
public class GroupDAO extends DBConnection {

    public SystemGroup getById(Long id) {
        SystemGroup sg = null;
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from systemgroup order by id asc";
            ResultSet rs = st.executeQuery(query);
            rs.next();

            sg = new SystemGroup(rs.getLong("id"), rs.getString("gname"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sg;
    }

    public void create(SystemGroup k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into systemgroup (gname) values ('" + k.getGname() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(SystemGroup k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update systemgroup set gname='" + k.getGname() + "' where id='" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(SystemGroup k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "delete from systemgroup where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<SystemGroup> getList(int page) {
        int offset = (page - 1) * 5;
        List<SystemGroup> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from systemgroup order by id asc limit 5 offset " + offset;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new SystemGroup(rs.getLong("id"), rs.getString("gname")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<SystemGroup> getList() {

        List<SystemGroup> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from systemgroup order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new SystemGroup(rs.getLong("id"), rs.getString("gname")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
