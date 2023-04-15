package com.appweb.psicologa.psicologa.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.appweb.psicologa.psicologa.model.BlogMetadata;
import org.springframework.stereotype.Repository;

@Repository
public class BlogMetadataRep implements InterfaceRep<BlogMetadata>{

    @Override
    public List<BlogMetadata> buscarAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BlogMetadata buscarPerId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean guardar(BlogMetadata terapies) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(BlogMetadata terapies) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
