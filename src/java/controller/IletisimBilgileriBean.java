package controller;

import dao.IletisimBilgileriDAO;
import entity.IletisimBilgileri;
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
@Named(value = "IletisimBilgileriBean")
@SessionScoped
public class IletisimBilgileriBean implements Serializable {

    private IletisimBilgileri entity;
    private IletisimBilgileriDAO dao;
    private List<IletisimBilgileri> list;
    private int page = 1;
    private int pageCount = 0;

    public IletisimBilgileriBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new IletisimBilgileri();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new IletisimBilgileri();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new IletisimBilgileri();
    }

    public void clear() {
        entity = new IletisimBilgileri();
    }

    public IletisimBilgileri getEntity() {
        if (entity == null) {
            entity = new IletisimBilgileri();
        }
        return entity;
    }

    public void setEntity(IletisimBilgileri entity) {
        this.entity = entity;
    }

    public IletisimBilgileriDAO getDao() {
        if (dao == null) {
            dao = new IletisimBilgileriDAO();
        }
        return dao;
    }

    public void setDao(IletisimBilgileriDAO dao) {
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

    public List<IletisimBilgileri> getList() {
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<IletisimBilgileri> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<IletisimBilgileri> glist = this.getDao().getList();
        int size = glist.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
