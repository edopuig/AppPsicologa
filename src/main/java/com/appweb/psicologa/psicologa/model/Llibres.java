package com.appweb.psicologa.psicologa.model;

import java.sql.Date;

public class Llibres {

    private int idLlibres;
    private String nomLlibre;
    private String descripcioLlibre;
    private Date dataCreacio;
    private String imatge;

    public int getIdLlibres() {
        return idLlibres;
    }
    public void setIdLlibres(int idLlibres) {
        this.idLlibres = idLlibres;
    }
    public String getNomLlibre() {
        return nomLlibre;
    }
    public void setNomLlibre(String nomLlibre) {
        this.nomLlibre = nomLlibre;
    }
    public String getDescripcioLlibre() {
        return descripcioLlibre;
    }
    public void setDescripcioLlibre(String descripcioLlibre) {
        this.descripcioLlibre = descripcioLlibre;
    }
    public Date getDataCreacio() {
        return dataCreacio;
    }
    public void setDataCreacio(Date dataCreacio) {
        this.dataCreacio = dataCreacio;
    }
    public String getImatge() {
        return imatge;
    }
    public void setImatge(String imatge) {
        this.imatge = imatge;
    }    
}
