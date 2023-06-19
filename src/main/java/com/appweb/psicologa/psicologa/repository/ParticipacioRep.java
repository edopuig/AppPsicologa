package com.appweb.psicologa.psicologa.repository;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.appweb.psicologa.psicologa.mapper.ParticipacioMapper;
import com.appweb.psicologa.psicologa.model.Participacio;

@Repository
public class ParticipacioRep implements InterfacreGeneral<Participacio> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void PostConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Participacio> buscarAll() {
        return jdbcTemplate.query("SELECT * From participacio", new ParticipacioMapper());
    }

    @Override
    public Participacio buscarPerId(int id) {
        return jdbcTemplate.queryForObject("SELECT * From participacio where IdParticipacio=?",
                new ParticipacioMapper(), id);
    }

    public List<Participacio> buscarPerIdAgenda(int id) {
        return jdbcTemplate.query("SELECT * From participacio where idAgenda=?", new ParticipacioMapper(), id);
    }

    public List<Participacio> buscarPerIdUsuari(int id) {
        return jdbcTemplate.query("SELECT * From participacio where idUsuari=?", new ParticipacioMapper(), id);
    }

    @Override
    public boolean guardar(Participacio participacio) {
        try {
            String sql = "insert into participacio(IdAgenda,IdUsuari) values(?,?)";
            jdbcTemplate.update(sql, participacio.getIdAgenda(), participacio.getIdUsuari());
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Participacio participacio) {
        if (participacio.getIdParticipacio() > 0) {
            try {
                String sql = String.format(
                        "update participacio set IdAgenda='%d', IdUsuari='%d' where IdParticipacio='%d'",
                        participacio.getIdAgenda(), participacio.getIdUsuari(), participacio.getIdParticipacio());
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
                    "delete from participacio where IdParticipacio='%d'", id);
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean eliminarByIdAgendaIdUsuari(int idAgenda, int idUsuari) {
        try {
            String sql = String.format(
                    "delete from participacio where IdAgenda='%d' AND IdUsuari='%d'", idAgenda,idUsuari);
            jdbcTemplate.update(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

}
