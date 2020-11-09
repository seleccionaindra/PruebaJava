package api.rest.indra.models.service;

import java.util.List;

import api.rest.indra.models.Persona;

public interface IPersonaService {

	public Persona crearPersona(Persona persona);
	
	public Persona getPersona(Long cedula);
	
	public List<Persona> getPersonas();
	
	public Persona updatePersona(Long cedula, Persona persona);
	
	public Persona deletePersona(Long cedula);
}
