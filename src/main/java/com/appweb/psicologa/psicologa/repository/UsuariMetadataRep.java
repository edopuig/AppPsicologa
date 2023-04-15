package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.appweb.psicologa.psicologa.model.UsuariMetadata;

import org.springframework.stereotype.Repository;

@Repository
public class UsuariMetadataRep implements InterfaceRep<UsuariMetadata>{

    @Override
    public List<UsuariMetadata> buscarAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UsuariMetadata buscarPerId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean guardar(UsuariMetadata terapies) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(UsuariMetadata terapies) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
