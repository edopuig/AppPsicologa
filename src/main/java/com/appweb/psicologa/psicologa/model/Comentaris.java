package com.appweb.psicologa.psicologa.model;
import java.util.Date;

public class Comentaris {
    private int idComentaris;
    private String comentari;
    private int idBlog; //Fa referencia al blog que ha comentat.
    private int idUsuari; // Fa referencia al usuari que ha fet el comentari.
    private Date dataComentari; // Quan es va fer el comentari
    private String respostaComentari; //Si s'ha creat una resposta al comentari
    
    public int getIdComentaris() {
        return idComentaris;
    }
    public void setIdComentaris(int idComentaris) {
        this.idComentaris = idComentaris;
    }
    public String getComentari() {
        return comentari;
    }
    public void setComentari(String comentari) {
        this.comentari = comentari;
    }
    public int getIdBlog() {
        return idBlog;
    }
    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }
    public int getIdUsuari() {
        return idUsuari;
    }
    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }
    public Date getDataComentari() {
        return dataComentari;
    }
    public void setDataComentari(Date dataComentari) {
        this.dataComentari = dataComentari;
    }
    public String getRespostaComentari() {
        return respostaComentari;
    }
    public void setRespostaComentari(String respostaComentari) {
        this.respostaComentari = respostaComentari;
    }

    
}
