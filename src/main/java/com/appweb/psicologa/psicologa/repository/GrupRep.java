package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.appweb.psicologa.psicologa.model.Grup;
import org.springframework.stereotype.Repository;

@Repository
public class GrupRep implements InterfaceRep<Grup>{

    @Override
    public List<Grup> buscarAll(Pageable pageable) {
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
