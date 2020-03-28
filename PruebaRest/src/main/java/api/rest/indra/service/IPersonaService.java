package api.rest.indra.service;

import java.util.List;

import api.rest.indra.exception.PersonaNotFoundException;
import api.rest.indra.model.Persona;

public interface IPersonaService {
	
	public List<Persona> getPersonas();
	
	public Persona createPersona(Persona newPersona);
	
	public Persona getPersona(Long id) throws PersonaNotFoundException;
	
	public Persona updatePersona(Persona newPersona, Long id) throws PersonaNotFoundException;
	
	public void removePersona(Long id) throws PersonaNotFoundException;
}