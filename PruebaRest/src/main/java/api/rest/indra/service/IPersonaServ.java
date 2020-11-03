package api.rest.indra.service;

import java.util.List;

import api.rest.indra.model.Persona;

public interface IPersonaServ {
	
	String crearPersona(Persona persona);
	String modificarPersona(Persona persona);
	Persona consultarPersona(Integer ID);
	List<Persona> consultarPersonas();
	void borrarProducto(Integer ID);

}
