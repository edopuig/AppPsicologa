package com.appweb.psicologa.psicologa.mapper;


import org.springframework.jdbc.core.RowMapper;
import com.appweb.psicologa.psicologa.model.Usuari;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuariMapper implements RowMapper<Usuari>{
    
    @Override
    public Usuari mapRow(ResultSet rs, int rowNum) throws SQLException{
        Usuari usuari = new Usuari();
        
        usuari.setIdUsuari(rs.getInt("IdUsuaris"));
        usuari.setNomUsuari(rs.getString("Nom"));
        usuari.setCognomUsuari(rs.getString("Cognom"));
        usuari.setContrasenyaUsuari(rs.getString("Contrasenya"));
        usuari.setCorreuUsuari(rs.getString("CorreuElectronic"));
        usuari.setIdRol(rs.getInt("IdRol"));
        usuari.setTelefonUsuari(rs.getInt("Telefon"));
        usuari.setNewsletter(rs.getInt("Newsletter"));

        return usuari;
    }
}
