package api.rest.indra.service;

import java.util.List;

import api.rest.indra.model.entity.Personas;

public interface IPersonasService {

	List<Personas> buscarPersonasTodo();

	void guardarPersona(Personas personas);

	void actualizarPersona(Personas personas);

	void borrarPersona(String cedula);

	Personas buscarPersona(String cedula);

}