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
    private int page = 1;
    private int pageCount = 0;

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

    public void previous() {
        page--;
        if (page < 1) {
            page = this.getPageCount();
        }
    }

    public void next() {
        page++;
        if (page > this.pageCount) {
            page = 1;
        }
    }

    public List<SystemUser> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<SystemUser> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<SystemUser> glist = this.getDao().getList();
        int size = glist.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
