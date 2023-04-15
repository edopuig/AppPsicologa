package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import com.appweb.psicologa.psicologa.model.Permis;
import org.springframework.stereotype.Repository;

@Repository
public class PremisRep implements InterfaceRep<Permis>{

    @Override
    public List<Permis> buscarAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Permis buscarPerId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean guardar(Permis terapies) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Permis terapies) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
