package api.rest.indra.services;

import api.rest.indra.dao.IPersonaDao;
import api.rest.indra.entities.Persona;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService implements ICrudService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    public List<Persona> getPersona() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public Persona addPersona(Persona persona) {
        return personaDao.save(persona);
    }

    @Override
    public void removePersona(String id) {
        personaDao.deleteById(id);
    }

    @Override
    public Persona updatePersona(Persona persona) {
        return personaDao.save(persona);
    }

    public IPersonaDao getPersonaDao() {
        return personaDao;
    }

    public void setPersonaDao(IPersonaDao personaDao) {
        this.personaDao = personaDao;
    }    
}
