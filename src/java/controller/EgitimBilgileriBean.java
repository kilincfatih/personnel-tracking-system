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
    private int page = 1;
    private int pageCount = 0;

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

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new EgitimBilgileri();
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

    public List<EgitimBilgileri> getList() {
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<EgitimBilgileri> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<EgitimBilgileri> list = this.getDao().getList();
        int size = list.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
