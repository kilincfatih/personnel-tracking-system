/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package converter;

import dao.KisiselBilgilerDAO;
import entity.KisiselBilgiler;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.context.FacesContext;
import jakarta.faces.component.UIComponent;
import jakarta.faces.convert.Converter;

/**
 *
 * @author USER
 */
/*
@FacesConverter ("kisBilConverter")

public class KisiselBilgilerConverter implements Converter {
    
    private KisiselBilgilerDAO kisiselBilgilerDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        KisiselBilgiler k = this.getKisiselBilgilerDao().findByID(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        KisiselBilgiler k = (KisiselBilgiler)t;
        return String.valueOf(k.getId());
    }

    public KisiselBilgilerDAO getKisiselBilgilerDao() {
        if (kisiselBilgilerDao == null) {
            this.kisiselBilgilerDao = new KisiselBilgilerDAO();
        }
        return kisiselBilgilerDao;

    }

    public void setKisiselBilgilerDao(KisiselBilgilerDAO KisiselBilgilerDao) {
        this.kisiselBilgilerDao = KisiselBilgilerDao;
    }

}
*/