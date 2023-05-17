package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import com.appweb.psicologa.psicologa.model.GrupPermis;
import org.springframework.stereotype.Repository;

@Repository
public class GrupPremisRep implements InterfacreGeneral<GrupPermis>{

    @Override
    public List<GrupPermis> buscarAll() {
        return null;
    }

    @Override
    public GrupPermis buscarPerId(int id) {
        return null;
    }

    @Override
    public boolean guardar(GrupPermis terapies) {
        return false;
    }

    @Override
    public boolean update(GrupPermis terapies) {
        return false;
    }
    
}
