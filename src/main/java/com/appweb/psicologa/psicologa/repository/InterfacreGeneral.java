package com.appweb.psicologa.psicologa.repository;

import java.util.List;

public interface InterfacreGeneral<Objet> {
    public boolean guardar(Objet activitat);
    public boolean update(Objet activitat);
    public List<Objet> buscarAll();
    public Objet buscarPerId(int id);
}
