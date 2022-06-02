package controller;

import dao.BankaBilgileriDAO;
import entity.BankaBilgileri;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Taha Kubilay ÖZDOĞAN - 02205076007
 * @author Fatih KILINÇ - 02205076006
 * @author Eren ALPARSLAN - 02205076019
 */
@Named(value = "BankaBilgileriBean")
@SessionScoped
public class BankaBilgileriBean implements Serializable {

    private BankaBilgileri entity;
    private BankaBilgileriDAO dao;
    private List<BankaBilgileri> list;

    public BankaBilgileriBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new BankaBilgileri();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new BankaBilgileri();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new BankaBilgileri();
    }

    public void clear() {
        entity = new BankaBilgileri();
    }

    public BankaBilgileri getEntity() {
        if (entity == null) {
            entity = new BankaBilgileri();
        }
        return entity;
    }

    public void setEntity(BankaBilgileri entity) {
        this.entity = entity;
    }

    public BankaBilgileriDAO getDao() {
        if (dao == null) {
            dao = new BankaBilgileriDAO();
        }
        return dao;
    }

    public void setDao(BankaBilgileriDAO dao) {
        this.dao = dao;
    }

    public List<BankaBilgileri> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<BankaBilgileri> list) {
        this.list = list;
    }

}
