package com.appweb.psicologa.psicologa.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.appweb.psicologa.psicologa.model.Terapies;

public class TerapiesMapper implements RowMapper<Terapies>{
    
    @Override
    public Terapies mapRow(ResultSet rs, int rowNum) throws SQLException{
        Terapies terapies = new Terapies();
        
        terapies.setIdTerapies(rs.getInt("IdTerapies"));
        terapies.setNomTerapia(rs.getString("Nom"));
        terapies.setDescripcioTerapia(rs.getString("Descripcio"));
        terapies.setDataTerapia(rs.getDate("Fecha"));
        terapies.setDuracioTerapia(rs.getInt("Duracio"));

        return terapies;
    }
}
