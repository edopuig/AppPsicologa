package com.appweb.psicologa.psicologa.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.appweb.psicologa.psicologa.model.Agenda;

public class AgendaMapper implements RowMapper<Agenda>{
    
    @Override
    public Agenda mapRow(ResultSet rs, int rowNum) throws SQLException{
        Agenda agenda = new Agenda();
        
        agenda.setIdActivitat(rs.getInt("IdActivitat"));
        agenda.setIdAgenda(rs.getInt("IdAgenda"));
        agenda.setDataActivitat(rs.getDate("DataActivitat"));

        return agenda;
    }
}