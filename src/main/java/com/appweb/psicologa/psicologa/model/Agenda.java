package com.appweb.psicologa.psicologa.model;

import java.util.Date;

public class Agenda {
    private int idAgenda;
    private Date dataActivitat;
    private int idActivitat;
    
    public int getIdAgenda() {
        return idAgenda;
    }
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }
    public Date getDataActivitat() {
        return dataActivitat;
    }
    public void setDataActivitat(Date dataActivitat) {
        this.dataActivitat = dataActivitat;
    }
    public int getIdActivitat() {
        return idActivitat;
    }
    public void setIdActivitat(int idActivitat) {
        this.idActivitat = idActivitat;
    }
    
}
