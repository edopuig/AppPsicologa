package com.appweb.psicologa.psicologa.model;

public class Usuari {
    private int idUsuari;
    private String nomUsuari;
    private String cognomUsuari;
    private String contrasenyaUsuari;
    private String correuUsuari;
    private int idGrup;

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
    public int getIdGrup() {
        return idGrup;
    }
    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }
}
