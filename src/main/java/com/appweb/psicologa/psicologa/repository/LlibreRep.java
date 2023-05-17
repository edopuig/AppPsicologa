package com.appweb.psicologa.psicologa.repository;

import java.util.List;
import java.sql.Date;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.appweb.psicologa.psicologa.mapper.LlibresMapper;
import com.appweb.psicologa.psicologa.model.Llibres;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;


@Repository
public class LlibreRep implements InterfacreGeneral<Llibres>{
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void PostConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Llibres> buscarAll() {
        return jdbcTemplate.query("SELECT * From llibres", new LlibresMapper());
    }

    @Override
    public Llibres buscarPerId(int id) {
        return jdbcTemplate.queryForObject("SELECT * From llibres where idLlibres=?", new LlibresMapper(), id);
    }

    @Override
    public boolean guardar(Llibres llibre) {
        Date date = new Date(new java.util.Date().getTime());
        try {
            String sql = "insert into llibres(nomLlibre,descripcioLlibre,imatge,dataCreacio) values(?,?,?,?)";
                jdbcTemplate.update(sql, llibre.getNomLlibre(), llibre.getDescripcioLlibre(), llibre.getImatge(), date);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Llibres llibre) {
        if (llibre.getIdLlibres() > 0) {
            try {
                String sql = String.format(
                        "update llibres set nomLlibre='%s', descripcioLlibre='%s', imatge='%s' where IdLlibres='%d'",
                        llibre.getNomLlibre(), llibre.getDescripcioLlibre(), llibre.getImatge(), llibre.getIdLlibres());
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
                    "delete from llibres where IdLlibres='%d'", id);
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
}
