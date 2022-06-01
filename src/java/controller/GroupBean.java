package controller;

import dao.GroupDAO;
import entity.SystemGroup;
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

@Named(value = "GroupBean")
@SessionScoped
public class GroupBean implements Serializable {

    private SystemGroup entity;
    private GroupDAO dao;
    private List<SystemGroup> list;

    public GroupBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new SystemGroup();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new SystemGroup();
    }
        
    public void delete() {
        this.getDao().delete(entity);
        this.entity = new SystemGroup();
    }

    public void clear() {
        entity = new SystemGroup();
    }
    

    public SystemGroup getEntity() {
        if (entity == null) {
            entity = new SystemGroup();
        }
        return entity;
    }

    public void setEntity(SystemGroup entity) {
        this.entity = entity;
    }

    public GroupDAO getDao() {
        if (dao == null) {
            dao = new GroupDAO();
        }
        return dao;
    }

    public void setDao(GroupDAO dao) {
        this.dao = dao;
    }

    public List<SystemGroup> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<SystemGroup> list) {
        this.list = list;
    }
    
}
  
