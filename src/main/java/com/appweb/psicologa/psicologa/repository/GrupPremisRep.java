package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.appweb.psicologa.psicologa.model.GrupPermis;
import org.springframework.stereotype.Repository;

@Repository
public class GrupPremisRep implements InterfaceRep<GrupPermis>{

    @Override
    public List<GrupPermis> buscarAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GrupPermis buscarPerId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean guardar(GrupPermis terapies) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(GrupPermis terapies) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
