package controller;

import dao.DepartmanBilgileriDAO;
import entity.DepartmanBilgileri;
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

@Named(value = "DepartmanBilgileriBean")
@SessionScoped

public class DepartmanBilgileriBean implements Serializable {

    private DepartmanBilgileri entity;
    private DepartmanBilgileriDAO dao;
    private List<DepartmanBilgileri> list;

    public DepartmanBilgileriBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new DepartmanBilgileri();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new DepartmanBilgileri();
    }
    
    public String getTc(int id){
        DepartmanBilgileri k = this.getDao().findByID(id);
        return k.getTc();
    }
    
    public void delete(DepartmanBilgileri entity) {
        this.getDao().delete(entity);
    }

    public void clear() {
        entity = new DepartmanBilgileri();
    }
    

    public DepartmanBilgileri getEntity() {
        if (entity == null) {
            entity = new DepartmanBilgileri();
        }
        return entity;
    }

    public void setEntity(DepartmanBilgileri entity) {
        this.entity = entity;
    }

    public DepartmanBilgileriDAO getDao() {
        if (dao == null) {
            dao = new DepartmanBilgileriDAO();
        }
        return dao;
    }

    public void setDao(DepartmanBilgileriDAO dao) {
        this.dao = dao;
    }

    public List<DepartmanBilgileri> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<DepartmanBilgileri> list) {
        this.list = list;
    }
    
}
  
