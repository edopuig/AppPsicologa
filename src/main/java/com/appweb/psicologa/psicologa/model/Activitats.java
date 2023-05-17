package com.appweb.psicologa.psicologa.model;

import java.sql.Date;

public class Activitats {
    private int idActivitat;
    private String titolActivitat;
    private String descripcio;
    private String imgDestacada;
    private Date dataPublicacio;
    private int tipus;
    private int activitatDestacada;
    private String videoActivitat;
    private int duracioActivitat;
    private String ubicacio;
    private int anulada;

    
    public int getIdActivitat() {
        return idActivitat;
    }
    public void setIdActivitat(int idActivitat) {
        this.idActivitat = idActivitat;
    }
    public String getTitolActivitat() {
        return titolActivitat;
    }
    public void setTitolActivitat(String titolActivitat) {
        this.titolActivitat = titolActivitat;
    }
    public String getDescripcio() {
        return descripcio;
    }
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    public String getImgDestacada() {
        return imgDestacada;
    }
    public void setImgDestacada(String imgDestacada) {
        this.imgDestacada = imgDestacada;
    }
    public Date getDataPublicacio() {
        return dataPublicacio;
    }
    public void setDataPublicacio(Date dataPublicacio) {
        this.dataPublicacio = dataPublicacio;
    }
    public int getTipus() {
        return tipus;
    }
    public void setTipus(int tipus) {
        this.tipus = tipus;
    }
    public int getActivitatDestacada() {
        return activitatDestacada;
    }
    public void setActivitatDestacada(int activitatDestacada) {
        this.activitatDestacada = activitatDestacada;
    }
    public String getVideoActivitat() {
        return videoActivitat;
    }
    public void setVideoActivitat(String videoActivitat) {
        this.videoActivitat = videoActivitat;
    }
    public int getDuracioActivitat() {
        return duracioActivitat;
    }
    public void setDuracioActivitat(int duracioActivitat) {
        this.duracioActivitat = duracioActivitat;
    }
    public String getUbicacio() {
        return ubicacio;
    }
    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }
    public int getAnulada() {
        return anulada;
    }
    public void setAnulada(int anulada) {
        this.anulada = anulada;
    }
    
    
}
