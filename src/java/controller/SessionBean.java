/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import entity.SystemUser;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author USER
 */
@Named(value = "SessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private SystemUser user;
    private UserDAO udao;
    private String email;
    private String pass;
    private int page = 1;
    private int pageCount = 0;

    public SessionBean() {
    }

    public String login() {
        SystemUser user = this.getUdao().getUser(this.email, this.pass);
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
            return "/panel/panel?faces-redirect-true";
        } else {
            FacesContext.getCurrentInstance().addMessage("Email or Password is incorrect", new FacesMessage("Email or Password is incorrect"));
            return "/index?faces-redirect-true";

        }
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public UserDAO getUdao() {
        if (this.udao == null) {
            this.udao = new UserDAO();
        }
        return udao;
    }

    public void setUdao(UserDAO udao) {
        this.udao = udao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
