package controller;

import dao.AileBilgileriDAO;
import entity.AileBilgileri;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Taha Kubilay ÖZDOĞAN - 02205076007
 * @author Fatih KILINÇ - 02205076006
 * @author Eren ALPARSLAN - 02205076019
 */

@Named(value = "AileBilgileriBean")
@SessionScoped
public class AileBilgileriBean implements Serializable {

    private AileBilgileri entity;
    private AileBilgileriDAO dao;
    private List<AileBilgileri> list;

    public AileBilgileriBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new AileBilgileri();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new AileBilgileri();
    }

    public void delete(AileBilgileri entity) {
        this.getDao().delete(entity);
    }

    public void clear() {
        entity = new AileBilgileri();
    }
    

    public AileBilgileri getEntity() {
        if (entity == null) {
            entity = new AileBilgileri();
        }
        return entity;
    }

    public void setEntity(AileBilgileri entity) {
        this.entity = entity;
    }

    public AileBilgileriDAO getDao() {
        if (dao == null) {
            dao = new AileBilgileriDAO();
        }
        return dao;
    }

    public void setDao(AileBilgileriDAO dao) {
        this.dao = dao;
    }

    public List<AileBilgileri> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<AileBilgileri> list) {
        this.list = list;
    }
    
}
