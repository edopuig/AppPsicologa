package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import com.appweb.psicologa.psicologa.model.Grup;
import org.springframework.stereotype.Repository;

@Repository
public class GrupRep implements InterfacreGeneral<Grup>{

    @Override
    public List<Grup> buscarAll() {
        return null;
    }

    @Override
    public Grup buscarPerId(int id) {
        return null;
    }

    @Override
    public boolean guardar(Grup terapies) {
        return false;
    }

    @Override
    public boolean update(Grup terapies) {
        return false;
    }
}
