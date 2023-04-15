package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.appweb.psicologa.psicologa.model.Usuari;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository
public class UsuariRep implements InterfaceRep<Usuari>{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    /*
     * Aixo el que fa es que quan ens conectem a la bvdd desde
     * DatabaseConfiguration, aixo carregara TerapiesRepository i abans de que
     * s'executi s'injecten aquestes
     * dependencies.
     */
    @PostConstruct
    public void PostConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Usuari> buscarAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuari buscarPerId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean guardar(Usuari user) {
        try {
            String sql = String.format("insert into Terapies(Nom,Cognom,Contrassenya,Correu,IdGrup) values('%s', '%s', %d)",
            user.getNomUsuari(), user.getCognomUsuari(), user.getContrasenyaUsuari(), user.getCorreuUsuari(), user.getIdGrup());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Usuari user) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
