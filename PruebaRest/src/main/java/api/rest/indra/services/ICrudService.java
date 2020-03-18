package api.rest.indra.services;

import api.rest.indra.entities.Persona;
import java.util.List;

public interface ICrudService {

    public List<Persona> getPersona();

    public Persona addPersona(Persona persona);

    public void removePersona(String id);

    public Persona updatePersona(Persona persona);

}
