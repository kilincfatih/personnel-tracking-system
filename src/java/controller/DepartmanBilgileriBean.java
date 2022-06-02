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
    private int page = 1;
    private int pageCount = 0;

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

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new DepartmanBilgileri();
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

    public List<DepartmanBilgileri> getList() {
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<DepartmanBilgileri> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<DepartmanBilgileri> list = this.getDao().getList();
        int size = list.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
