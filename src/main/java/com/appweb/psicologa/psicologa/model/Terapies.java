package com.appweb.psicologa.psicologa.model;

import java.util.Date;

public class Terapies {
    private int idTerapies;
    private String titolTerapies;
    private String descripcioTerapies;
    private Date dataTerapia;
    private int duracioTerapia;
    private String imatge;

    public int getIdTerapies() {
        return idTerapies;
    }
    public void setIdTerapies(int idTerapies) {
        this.idTerapies = idTerapies;
    }
    public String getTitolTerapies() {
        return titolTerapies;
    }
    public void setTitolTerapies(String titolTerapies) {
        this.titolTerapies = titolTerapies;
    }
    public String getDescripcioTerapies() {
        return descripcioTerapies;
    }
    public void setDescripcioTerapies(String descripcioTerapies) {
        this.descripcioTerapies = descripcioTerapies;
    }
    public Date getDataTerapia() {
        return dataTerapia;
    }
    public void setDataTerapia(Date dataTerapia) {
        this.dataTerapia = dataTerapia;
    }
    public int getDuracioTerapia() {
        return duracioTerapia;
    }
    public void setDuracioTerapia(int duracioTerapia) {
        this.duracioTerapia = duracioTerapia;
    }
    public String getImatge() {
        return imatge;
    }
    public void setImatge(String imatge) {
        this.imatge = imatge;
    }
 
        
}
