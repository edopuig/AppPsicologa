package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import com.appweb.psicologa.psicologa.model.Blogs;
import org.springframework.stereotype.Repository;

@Repository
public class BlogsRep implements InterfaceRep<Blogs>{

    @Override
    public List<Blogs> buscarAll() {
        return null;
    }

    @Override
    public Blogs buscarPerId(int id) {
        return null;
    }

    @Override
    public boolean guardar(Blogs terapies) {
        return false;
    }

    @Override
    public boolean update(Blogs terapies) {
        return false;
    }
    
}
