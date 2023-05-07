package com.appweb.psicologa.psicologa.model;

public class Usuari {
    private int idUsuari;
    private String nomUsuari;
    private String cognomUsuari;
    private String contrasenyaUsuari;
    private String correuUsuari;
    private int idRol;
    private int telefonUsuari;
    private int newsletter;

    public int getIdUsuari() {
        return idUsuari;
    }
    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }
    public String getNomUsuari() {
        return nomUsuari;
    }
    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }
    public String getCognomUsuari() {
        return cognomUsuari;
    }
    public void setCognomUsuari(String cognomUsuari) {
        this.cognomUsuari = cognomUsuari;
    }
    public String getContrasenyaUsuari() {
        return contrasenyaUsuari;
    }
    public void setContrasenyaUsuari(String contrasenyaUsuari) {
        this.contrasenyaUsuari = contrasenyaUsuari;
    }
    public String getCorreuUsuari() {
        return correuUsuari;
    }
    public void setCorreuUsuari(String correuUsuari) {
        this.correuUsuari = correuUsuari;
    }
    public int getIdRol() {
        return idRol;
    }
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    public int getTelefonUsuari() {
        return telefonUsuari;
    }
    public void setTelefonUsuari(int telefonUsuari) {
        this.telefonUsuari = telefonUsuari;
    }
    public int getNewsletter() {
        return newsletter;
    }
    public void setNewsletter(int newsletter) {
        this.newsletter = newsletter;
    }

}
