package com.appweb.psicologa.psicologa.repository;

import java.util.List;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

public interface InterfaceRep<Objet> {
    public boolean guardar(Objet terapies);
    public boolean update(Objet terapies);
    public List<Objet> buscarAll(Pageable pageable);
    public Objet buscarPerId(int id);
}
