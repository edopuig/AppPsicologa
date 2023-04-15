package com.appweb.psicologa.psicologa.model;

public class UsuariMetadata {
    private int idUsuariMetadata;
    private int idUsuari;
    private String clauUsuariMetadata;
    private String valorUsuariMetadata;
    private String tipusUsuariMetadata;

    public int getIdUsuariMetadata() {
        return idUsuariMetadata;
    }
    public void setIdUsuariMetadata(int idUsuariMetadata) {
        this.idUsuariMetadata = idUsuariMetadata;
    }
    public int getIdUsuari() {
        return idUsuari;
    }
    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }
    public String getClauUsuariMetadata() {
        return clauUsuariMetadata;
    }
    public void setClauUsuariMetadata(String clauUsuariMetadata) {
        this.clauUsuariMetadata = clauUsuariMetadata;
    }
    public String getValorUsuariMetadata() {
        return valorUsuariMetadata;
    }
    public void setValorUsuariMetadata(String valorUsuariMetadata) {
        this.valorUsuariMetadata = valorUsuariMetadata;
    }
    public String getTipusUsuariMetadata() {
        return tipusUsuariMetadata;
    }
    public void setTipusUsuariMetadata(String tipusUsuariMetadata) {
        this.tipusUsuariMetadata = tipusUsuariMetadata;
    }
}
