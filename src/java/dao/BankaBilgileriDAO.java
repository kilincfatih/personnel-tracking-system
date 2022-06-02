package dao;

import entity.BankaBilgileri;
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
public class BankaBilgileriDAO extends DBConnection {

    public void create(BankaBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into banka_bilgileri (banka_bilgiler_tc, ad_soyad, hesap_no, iban, banka_adi, sube_adi, sube_kodu) values ('" + k.getTc() + "', '" + k.getAdSoyad() + "', '" + k.getHesapNo() + "', '" + k.getIban() + "' , '" + k.getBankaAdi() + "', '" + k.getSubeAdi() + "', '" + k.getSubeKodu() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(BankaBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update banka_bilgileri set banka_bilgiler_tc ='" + k.getTc() + "', ad_soyad='" + k.getAdSoyad() + "', hesap_no='" + k.getHesapNo() + "', iban='" + k.getIban() + "', banka_adi='" + k.getBankaAdi() + "', sube_adi='" + k.getSubeAdi() + "', sube_kodu='" + k.getSubeKodu() + "' where id=" + k.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(BankaBilgileri k) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "delete from banka_bilgileri where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<BankaBilgileri> getList(int page) {
        List<BankaBilgileri> list = new ArrayList<>();
        int offset = (page - 1) * 5;
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from banka_bilgileri order by id asc limit 5 offset " + offset;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new BankaBilgileri(rs.getInt("id"), rs.getString("banka_bilgiler_tc"), rs.getString("ad_soyad"), rs.getString("hesap_no"), rs.getString("iban"), rs.getString("banka_adi"), rs.getString("sube_adi"), rs.getString("sube_kodu")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<BankaBilgileri> getList() {
        List<BankaBilgileri> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            String query = "select * from banka_bilgileri order by id asc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new BankaBilgileri(rs.getInt("id"), rs.getString("banka_bilgiler_tc"), rs.getString("ad_soyad"), rs.getString("hesap_no"), rs.getString("iban"), rs.getString("banka_adi"), rs.getString("sube_adi"), rs.getString("sube_kodu")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
