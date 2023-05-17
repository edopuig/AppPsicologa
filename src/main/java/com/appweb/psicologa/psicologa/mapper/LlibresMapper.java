package com.appweb.psicologa.psicologa.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.appweb.psicologa.psicologa.model.Llibres;

public class LlibresMapper implements RowMapper<Llibres>{
    
    @Override
    public Llibres mapRow(ResultSet rs, int rowNum) throws SQLException{
        Llibres llibre = new Llibres();
        llibre.setIdLlibres(rs.getInt("idLlibres"));
        llibre.setNomLlibre(rs.getString("nomLlibre"));
        llibre.setDescripcioLlibre(rs.getString("descripcioLlibre"));
        llibre.setDataCreacio(rs.getDate("dataCreacio"));
        llibre.setImatge(rs.getString("imatge"));
        return llibre;
    }
    
}
