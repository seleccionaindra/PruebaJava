package api.rest.indra.service;

import api.rest.indra.dto.PersonaDTO;
import api.rest.indra.dto.ResponseDTO;

public interface IPersonaService {

	public ResponseDTO devolverPersonas();

	public ResponseDTO eliminarPersona(String id);

	public ResponseDTO crearPersona(PersonaDTO persona);

	public ResponseDTO actualizarPersona(PersonaDTO persona);
}
