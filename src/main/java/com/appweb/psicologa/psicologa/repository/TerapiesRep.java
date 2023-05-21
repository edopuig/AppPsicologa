package com.appweb.psicologa.psicologa.repository;

import java.util.List;
import java.util.Date;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.appweb.psicologa.psicologa.mapper.TerapiesMapper;
import com.appweb.psicologa.psicologa.model.Terapies;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class TerapiesRep implements InterfacreGeneral<Terapies> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    /*
     * Aixo el que fa es que quan ens conectem a la bbdd desde
     * DatabaseConfiguration, carregara TerapiesRepository i abans de que
     * s'executi s'injecten aquestes
     * dependencies.
     */
    @PostConstruct
    public void PostConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean guardar(Terapies terapies) {
        Date date = new Date(new java.util.Date().getTime());

        try {
            String sql = "insert into terapies(titolTerapies,descripcioTerapies,imatge,dataPublicacio) values(?,?,?,?)";
                jdbcTemplate.update(sql, terapies.getTitolTerapies(), terapies.getDescripcioTerapies(),terapies.getImatge(), date);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Terapies terapies) {
        if (terapies.getIdTerapies() > 0) {
            try {
                String sql = String.format(
                        "update terapies set titolTerapies='%s', descripcioTerapies='%s', imatge='%s' where IdTerapies='%d'",
                        terapies.getTitolTerapies(), terapies.getDescripcioTerapies(),terapies.getImatge(), terapies.getIdTerapies());
                jdbcTemplate.execute(sql);
                return true;
            } catch (Exception e) {
                System.err.println(e);
                return false;
            }
        }
        return false;
    }

    @Override
    public List<Terapies> buscarAll() {

        return jdbcTemplate.query("SELECT * From terapies", new TerapiesMapper());
    }

    @Override
    public Terapies buscarPerId(int id) {
        return jdbcTemplate.queryForObject("SELECT * From terapies where idTerapies=?", new TerapiesMapper(), id);
    }

    public boolean eliminarById(int id) {
        try {
            String sql = String.format(
                    "delete from terapies where IdTerapies='%d'", id);
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    
}
