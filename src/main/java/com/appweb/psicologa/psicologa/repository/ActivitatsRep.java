package com.appweb.psicologa.psicologa.repository;

import java.util.List;
import java.sql.Date;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.appweb.psicologa.psicologa.mapper.ActivitatsMapper;
import com.appweb.psicologa.psicologa.model.Activitats;

import jakarta.annotation.PostConstruct;

@Repository
public class ActivitatsRep implements InterfacreGeneral<Activitats>{
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void PostConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Activitats> buscarAll() {
        return jdbcTemplate.query("SELECT * From activitats", new ActivitatsMapper());
    }

    @Override
    public Activitats buscarPerId(int id) {
        return jdbcTemplate.queryForObject("SELECT * From activitats where idActivitat=?", new ActivitatsMapper(), id);
    }

    @Override
    public boolean guardar(Activitats activitat) {
        Date date = new Date(new java.util.Date().getTime());

        try {
            String sql = "insert into activitats(titolActivitat,descripcio,imgDestacada,tipus,activitatDestacada,dataPublicacio) values(?,?,?,?,?,?)";
                jdbcTemplate.update(sql, activitat.getTitolActivitat(), activitat.getDescripcio(),activitat.getImgDestacada(),activitat.getTipus(),activitat.getActivitatDestacada(), date);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Activitats activitat) {
        if (activitat.getIdActivitat() > 0) {
            try {
                String sql = String.format(
                        "update activitats set titolActivitat='%s', descripcio='%s', activitatDestacada='%d' ,imgDestacada='%s' where idActivitat='%d'",
                        activitat.getTitolActivitat(), activitat.getDescripcio(),activitat.getActivitatDestacada() ,activitat.getImgDestacada(), activitat.getIdActivitat());
                jdbcTemplate.execute(sql);
                return true;
            } catch (Exception e) {
                System.err.println(e);
                return false;
            }
        }
        return false;
    }  
    
    
    public boolean eliminarById(int id) {
        try {
            String sql = String.format(
                    "delete from activitats where idActivitat='%d'", id);
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public List<Activitats> buscarAllByTipus(int tipus) {
        return jdbcTemplate.query("SELECT * From activitats Where tipus=?", new ActivitatsMapper(),tipus);
    }

    public List<Activitats> buscarActivitatDestacada() {
        return jdbcTemplate.query("SELECT * From activitats Where activitatDestacada=1", new ActivitatsMapper());
    }
}