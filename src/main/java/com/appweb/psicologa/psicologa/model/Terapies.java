package com.appweb.psicologa.psicologa.model;

import java.util.Date;

public class Terapies {
    private int idTerapies;
    private String nomTerapia;
    private String descripcioTerapia;
    private Date dataTerapia;
    private int duracioTerapia;

    public int getIdTerapies() {
        return idTerapies;
    }
    public void setIdTerapies(int idTerapies) {
        this.idTerapies = idTerapies;
    }
    public String getNomTerapia() {
        return nomTerapia;
    }
    public void setNomTerapia(String nomTerapia) {
        this.nomTerapia = nomTerapia;
    }
    public String getDescripcioTerapia() {
        return descripcioTerapia;
    }
    public void setDescripcioTerapia(String descripcioTerapia) {
        this.descripcioTerapia = descripcioTerapia;
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
}
