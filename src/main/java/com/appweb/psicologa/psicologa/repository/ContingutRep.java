package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.appweb.psicologa.psicologa.model.Contingut;
import org.springframework.stereotype.Repository;

@Repository
public class ContingutRep implements InterfaceRep<Contingut>{

    @Override
    public List<Contingut> buscarAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Contingut buscarPerId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean guardar(Contingut terapies) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Contingut terapies) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
