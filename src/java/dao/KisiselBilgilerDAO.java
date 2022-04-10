/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
            String query = "insert into kisisel_bilgiler (tc, isim, soy_isim, dogum_tarihi, medeni_hali) values ('" + k.getTc() + "', '" + k.getIsim() + "', '" + k.getSoyIsim() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(KisiselBilgiler k) {

        try {
            Statement st = this.connect().createStatement();
            String query = "update kisisel_bilgiler set tc ='" + k.getTc() + "', isim='" + k.getIsim() + "', soy_isim='" + k.getSoyIsim() + "' where id=" + k.getId();

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
                list.add(new KisiselBilgiler(rs.getInt("id"), rs.getString("tc"), rs.getString("isim"), rs.getString("soy_isim")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
