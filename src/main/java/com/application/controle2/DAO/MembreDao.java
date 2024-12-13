package com.application.controle2.DAO;


import com.application.controle2.model.Incident;
import com.application.controle2.model.Membre;

import java.util.List;

public interface MembreDao {
    public void insere(Membre m);
    public List<Incident> chargerListIncidents();
}
