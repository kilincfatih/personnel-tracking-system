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
    private int kPage = 1;
    private int kPageCount = 0;

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

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new KisiselBilgiler();
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

    public void previous() {
        kPage--;
        if (kPage < 1) {
            kPage = this.getkPageCount();
        }
    }

    public void next() {
        kPage++;
        if (kPage > this.getkPageCount()) {
            kPage = 1;
        }
    }

    public List<KisiselBilgiler> getList() {
        this.list = this.getDao().getList(kPage);
        return list;
    }

    public void setList(List<KisiselBilgiler> list) {
        this.list = list;
    }

    public int getkPage() {
        return kPage;
    }

    public void setkPage(int kPage) {
        this.kPage = kPage;
    }

    public int getkPageCount() {
        List<KisiselBilgiler> kList = this.getDao().getList();
        int size = kList.size();
        kPageCount = (int) Math.ceil(size / 5) + 1;
        return kPageCount;
    }

    public void setkPageCount(int kPageCount) {
        this.kPageCount = kPageCount;
    }
}
