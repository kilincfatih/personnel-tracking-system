package controller;

import dao.EgitimBilgileriDAO;
import entity.EgitimBilgileri;
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

@Named(value = "EgitimBilgileriBean")
@SessionScoped
public class EgitimBilgileriBean implements Serializable {

    private EgitimBilgileri entity;
    private EgitimBilgileriDAO dao;
    private List<EgitimBilgileri> list;

    public EgitimBilgileriBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new EgitimBilgileri();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new EgitimBilgileri();
    }
    
    public String getTc(int id){
        EgitimBilgileri k = this.getDao().findByID(id);
        return k.getTc();
    }
    
    public void delete(EgitimBilgileri entity) {
        this.getDao().delete(entity);
    }

    public void clear() {
        entity = new EgitimBilgileri();
    }
    

    public EgitimBilgileri getEntity() {
        if (entity == null) {
            entity = new EgitimBilgileri();
        }
        return entity;
    }

    public void setEntity(EgitimBilgileri entity) {
        this.entity = entity;
    }

    public EgitimBilgileriDAO getDao() {
        if (dao == null) {
            dao = new EgitimBilgileriDAO();
        }
        return dao;
    }

    public void setDao(EgitimBilgileriDAO dao) {
        this.dao = dao;
    }

    public List<EgitimBilgileri> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<EgitimBilgileri> list) {
        this.list = list;
    }
    
}
  
