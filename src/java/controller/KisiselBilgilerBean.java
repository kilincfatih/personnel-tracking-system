/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KisiselBilgilerDAO;
import entity.KisiselBilgiler;
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

@Named(value = "KisiselBilgilerBean")
@SessionScoped
public class KisiselBilgilerBean implements Serializable {

    private KisiselBilgiler entity;
    private KisiselBilgilerDAO dao;
    private List<KisiselBilgiler> list;

    public KisiselBilgilerBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new KisiselBilgiler();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new KisiselBilgiler();
    }

    public void delete(KisiselBilgiler entity) {
        this.getDao().delete(entity);
    }

    public void clear() {
        entity = new KisiselBilgiler();
    }
    

    public KisiselBilgiler getEntity() {
        if (entity == null) {
            entity = new KisiselBilgiler();
        }
        return entity;
    }

    public void setEntity(KisiselBilgiler entity) {
        this.entity = entity;
    }

    public KisiselBilgilerDAO getDao() {
        if (dao == null) {
            dao = new KisiselBilgilerDAO();
        }
        return dao;
    }

    public void setDao(KisiselBilgilerDAO dao) {
        this.dao = dao;
    }

    public List<KisiselBilgiler> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<KisiselBilgiler> list) {
        this.list = list;
    }
    
}
  
