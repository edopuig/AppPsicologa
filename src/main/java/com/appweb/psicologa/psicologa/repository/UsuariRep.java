package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import com.appweb.psicologa.psicologa.mapper.UsuariMapper;
import com.appweb.psicologa.psicologa.model.Usuari;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository
public class UsuariRep implements InterfaceRep<Usuari> {

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
    public List<Usuari> buscarAll() {
        return null;
    }

    @Override
    public Usuari buscarPerId(int id) {
        return null;
    }

    public Usuari getUsuariById(int id) {
        return jdbcTemplate.queryForObject("SELECT * From usuaris where IdUsuaris=?", new UsuariMapper(), id);
    }

    public Usuari getUsuariByCorreu(String correu) {
        return jdbcTemplate.queryForObject("SELECT * From usuaris where CorreuElectronic=?", new UsuariMapper(),
                correu);
    }

    public Usuari login(String correu, String contra) {
        try {
            Usuari usuari = jdbcTemplate.queryForObject(
                    "SELECT * From usuaris where CorreuElectronic=? AND Contrasenya=?", new UsuariMapper(), correu,
                    contra);
            if (usuari != null && usuari.getNomUsuari() != null) {
                return usuari;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public boolean guardar(Usuari user) {
        try {
            String sql = String.format(
                    "insert into usuaris(Nom,Cognom,Contrasenya,CorreuElectronic,IdRol,Telefon,Newsletter) values('%s', '%s', '%s','%s', %d, %d, %d)",
                    user.getNomUsuari(), user.getCognomUsuari(), user.getContrasenyaUsuari(), user.getCorreuUsuari(),
                    user.getIdRol(), user.getTelefonUsuari(), user.getNewsletter());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Usuari user) {
        return false;
    }

}
