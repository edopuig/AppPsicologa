package com.appweb.psicologa.psicologa.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.appweb.psicologa.psicologa.mapper.AgendaMapper;
import com.appweb.psicologa.psicologa.model.Agenda;

import jakarta.annotation.PostConstruct;

@Repository
public class AgendaRep implements InterfacreGeneral<Agenda> {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void PostConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Agenda> buscarAll() {
        return jdbcTemplate.query("SELECT * From agendactivitat", new AgendaMapper());
    }

    @Override
    public Agenda buscarPerId(int id) {
        return jdbcTemplate.queryForObject("SELECT * From agendactivitat where IdAgenda=?", new AgendaMapper(), id);
    }

    @Override
    public boolean guardar(Agenda agenda) {
        try {
            String sql = "insert into agendactivitat(DataActivitat,IdActivitat) values(?,?)";
            jdbcTemplate.update(sql, agenda.getDataActivitat(), agenda.getIdActivitat());
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Agenda agenda) {
        if (agenda.getIdActivitat() > 0) {
            try {
                String sql = String.format(
                        "update agendactivitat set DataActivitat='%d', IdActivitat='%d'",
                        agenda.getDataActivitat(), agenda.getIdActivitat());
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
                    "delete from agendactivitat where idAgenda='%d'", id);
            jdbcTemplate.update(sql);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean guardarByIdActivitatData(List<Date> dataActivitat, int idActivitat) {
        try {
            Calendar dia = Calendar.getInstance();
            for (Date data : dataActivitat) {
                dia.setTime(data);
                dia.add(Calendar.DATE, 1);
                data = dia.getTime();
                String sql = "insert into agendactivitat(DataActivitat,IdActivitat) values(?,?)";
                jdbcTemplate.update(sql, data, idActivitat);
            }
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean updateByIdActivitatData(List<Date> dataActivitat, int idActivitat) {
        try {
            for (Date data : dataActivitat) {
                String sql = "UPDATE agendactivitat SET DataActivitat = ? WHERE IdActivitat = ?";
                jdbcTemplate.update(sql, data, idActivitat);
            }
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public List<Agenda> buscarPerIdActivitat(int idActivitat) {
        return jdbcTemplate.query("SELECT * From agendactivitat where IdActivitat=?", new AgendaMapper(), idActivitat);
    }

    public List<Agenda> buscarPerIdAgendas(int idAgenda) {
        return jdbcTemplate.query("SELECT * From agendactivitat where IdAgenda=?", new AgendaMapper(), idAgenda);
    }

}