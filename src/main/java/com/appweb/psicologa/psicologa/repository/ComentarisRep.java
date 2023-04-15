package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.appweb.psicologa.psicologa.model.Comentaris;
import org.springframework.stereotype.Repository;

@Repository
public class ComentarisRep implements InterfaceRep<Comentaris>{

    @Override
    public List<Comentaris> buscarAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Comentaris buscarPerId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean guardar(Comentaris terapies) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Comentaris terapies) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
