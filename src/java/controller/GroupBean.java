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
    private int page = 1;
    private int pageCount = 0;

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

    public List<SystemGroup> getList() {
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<SystemGroup> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<SystemGroup> glist = this.getDao().getList();
        int size = glist.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
