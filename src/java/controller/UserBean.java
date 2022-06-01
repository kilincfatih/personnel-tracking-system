package controller;

import dao.UserDAO;
import entity.SystemUser;
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
@Named(value = "UserBean")
@SessionScoped
public class UserBean implements Serializable {

    private SystemUser entity;
    private UserDAO dao;
    private List<SystemUser> list;

    public UserBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new SystemUser();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new SystemUser();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new SystemUser();
    }

    public void clear() {
        entity = new SystemUser();
    }

    public SystemUser getEntity() {
        if (entity == null) {
            entity = new SystemUser();
        }
        return entity;
    }

    public void setEntity(SystemUser entity) {
        this.entity = entity;
    }

    public UserDAO getDao() {
        if (dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public List<SystemUser> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<SystemUser> list) {
        this.list = list;
    }

}
