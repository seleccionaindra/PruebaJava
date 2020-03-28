package api.rest.indra.services;

import api.rest.indra.domain.Exception.PersonaException;
import api.rest.indra.domain.Persona;
import java.util.List;

public interface IPersonaServices {
    List<Persona> get();
    Persona getPersona(Long id);
    Persona create(Persona persona);
    Persona update(Persona persona);
    void delete(Long id);
}
