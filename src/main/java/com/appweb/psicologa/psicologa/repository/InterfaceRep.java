package com.appweb.psicologa.psicologa.repository;

import java.util.List;

public interface InterfaceRep<Objet> {
    public boolean guardar(Objet terapies);
    public boolean update(Objet terapies);
    public List<Objet> buscarAll();
    public Objet buscarPerId(int id);
}
