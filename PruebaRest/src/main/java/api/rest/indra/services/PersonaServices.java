package api.rest.indra.services;

import api.rest.indra.domain.Exception.PersonaException;
import api.rest.indra.domain.Persona;
import api.rest.indra.persistence.IPersonaPersistence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServices implements IPersonaServices {

    @Autowired
    private IPersonaPersistence personaPersistence;
    
    private static final String MENSAJE_ERROR_BD = "No se encuentra el registro en nuestra BD";

    @Override
    public List<Persona> get() {
        return (List<Persona>) personaPersistence.findAll();
    }

    @Override
    public Persona create(Persona persona) {
        return personaPersistence.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        esValidoRegistro(persona.getId());
        return personaPersistence.save(persona);
    }

    @Override
    public void delete(Long id) {
        esValidoRegistro(id);
        personaPersistence.deleteById(id);
    }

    @Override
    public Persona getPersona(Long id) {
        esValidoRegistro(id);
        return personaPersistence.findById(id).get();
    }

    private void esValidoRegistro(Long id) throws PersonaException {
        if (!personaPersistence.findById(id).isPresent()) {
            throw new PersonaException(MENSAJE_ERROR_BD);
        }
    }

}
