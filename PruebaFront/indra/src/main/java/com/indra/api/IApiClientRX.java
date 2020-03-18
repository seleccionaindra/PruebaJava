package com.indra.api;

import com.indra.model.Persona;
import java.util.List;

public interface IApiClientRX {

    public List<Persona> getPersona();
    public void addPersona(Persona persona);
    public void removePersona(String id);
    public void updatePersona(Persona persona);

}
