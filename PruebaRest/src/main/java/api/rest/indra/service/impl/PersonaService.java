package api.rest.indra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rest.indra.dao.IPersonaDao;
import api.rest.indra.exception.PersonaNotFoundException;
import api.rest.indra.model.Persona;
import api.rest.indra.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private IPersonaDao personaDao;

	@Override
	public List<Persona> getPersonas() {
		return (List<Persona>) personaDao.findAll();
	}
	
	@Override
	public Persona createPersona(Persona newPersona) {
		return personaDao.save(newPersona);
	}
	
	@Override
	public Persona getPersona(Long id) throws PersonaNotFoundException {
		
		if (!personaDao.existsById(id)) {
			throw new PersonaNotFoundException(id);
		} 
		return personaDao.findById(id).get();
	}
	
	
	@Override
	public Persona updatePersona(Persona newPersona, Long id) throws PersonaNotFoundException {
		
		if (!personaDao.existsById(id)) {
			throw new PersonaNotFoundException(id);
		}
		
		return personaDao.save(newPersona);
		
	}
	
	public void removePersona(Long id) throws PersonaNotFoundException {
		
		if (!personaDao.existsById(id)) {
			throw new PersonaNotFoundException(id);
		}
		
		personaDao.deleteById(id);
	}
}
