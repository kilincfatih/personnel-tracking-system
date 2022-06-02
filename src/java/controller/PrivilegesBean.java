package controller;

import dao.PrivilegesDAO;
import entity.Privileges;
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
@Named(value = "PrivilegesBean")
@SessionScoped
public class PrivilegesBean implements Serializable {

    private Privileges entity;
    private PrivilegesDAO dao;
    private List<Privileges> list;
    private int page = 1;
    private int pageCount = 0;

    public PrivilegesBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new Privileges();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Privileges();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Privileges();
    }

    public void clear() {
        entity = new Privileges();
    }

    public Privileges getEntity() {
        if (entity == null) {
            entity = new Privileges();
        }
        return entity;
    }

    public void setEntity(Privileges entity) {
        this.entity = entity;
    }

    public PrivilegesDAO getDao() {
        if (dao == null) {
            dao = new PrivilegesDAO();
        }
        return dao;
    }

    public void setDao(PrivilegesDAO dao) {
        this.dao = dao;
    }

    public List<Privileges> getList() {
        this.list = this.getDao().getList(page);
        return list;
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

    public void setList(List<Privileges> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<Privileges> glist = this.getDao().getList();
        int size = glist.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
