package com.appweb.psicologa.psicologa.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.appweb.psicologa.psicologa.model.Participacio;

public class ParticipacioMapper implements RowMapper<Participacio>{
    
    @Override
    public Participacio mapRow(ResultSet rs, int rowNum) throws SQLException{
        Participacio participacio = new Participacio();
        
        participacio.setIdParticipacio(rs.getInt("IdParticipacio"));
        participacio.setIdAgenda(rs.getInt("IdAgenda"));
        participacio.setIdUsuari(rs.getInt("IdUsuari"));

        return participacio;
    }
}