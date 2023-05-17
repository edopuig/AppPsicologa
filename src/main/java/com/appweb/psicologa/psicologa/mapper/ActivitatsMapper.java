package com.appweb.psicologa.psicologa.mapper;


import org.springframework.jdbc.core.RowMapper;
import com.appweb.psicologa.psicologa.model.Activitats;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivitatsMapper implements RowMapper<Activitats>{
    
    @Override
    public Activitats mapRow(ResultSet rs, int rowNum) throws SQLException{
        Activitats activitat = new Activitats();
        
        activitat.setIdActivitat(rs.getInt("IdActivitat"));
        activitat.setTitolActivitat(rs.getString("TitolActivitat"));
        activitat.setDescripcio(rs.getString("Descripcio"));
        activitat.setImgDestacada(rs.getString("ImgDestacada"));
        activitat.setDataPublicacio(rs.getDate("DataPublicacio"));
        activitat.setTipus(rs.getInt("Tipus"));
        activitat.setActivitatDestacada(rs.getInt("ActivitatDestacada"));
        activitat.setVideoActivitat(rs.getString("VideoActivitat"));
        activitat.setDuracioActivitat(rs.getInt("DuracioActivitat"));
        activitat.setUbicacio(rs.getString("Ubicacio"));
        activitat.setAnulada(rs.getInt("Anulada"));

        return activitat;
    }
}
