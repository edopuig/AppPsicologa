package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;

import com.appweb.psicologa.psicologa.mapper.TerapiesMapper;
import com.appweb.psicologa.psicologa.model.Terapies;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class TerapiesRep implements InterfaceRep<Terapies> {

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
        try {
            String sql = String.format("insert into Terapies(Nom,Descripcio,Duracio) values('%s', '%s', %d)",
                    terapies.getNomTerapia(), terapies.getDescripcioTerapia(), terapies.getDuracioTerapia());
            jdbcTemplate.execute(sql);
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
                        "update Terapies set Nom='%s', Descripcio='%s',Duracio='%d' = where IdTerapies='%d'",
                        terapies.getNomTerapia(), terapies.getDescripcioTerapia(), terapies.getDuracioTerapia(),
                        terapies.getIdTerapies());
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
    public List<Terapies> buscarAll(Pageable pageable) {

        return jdbcTemplate.query("SELECT * From Terapies", new TerapiesMapper());
    }

    @Override
    public Terapies buscarPerId(int id) {
        return jdbcTemplate.queryForObject("SELECT * From Terapies where idTerapies=?", new TerapiesMapper(), id);
    }
}
