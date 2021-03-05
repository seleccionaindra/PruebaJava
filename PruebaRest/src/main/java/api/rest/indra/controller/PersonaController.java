package api.rest.indra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.indra.dto.PersonaDTO;
import api.rest.indra.dto.ResponseDTO;
import api.rest.indra.service.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaController {

	@Autowired
	IPersonaService personaServiceImpl;

	@GetMapping("/devolverPersonas")
	@CrossOrigin(origins = "*")
	public ResponseEntity<ResponseDTO> devolverPersonas() {
		ResponseDTO responseDTO = personaServiceImpl.devolverPersonas();
		return new ResponseEntity<>(responseDTO, responseDTO.getHttpStatus());
	}

	@DeleteMapping("/eliminarPersona/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<ResponseDTO> eliminarPersona(@PathVariable("id") String id) {
		ResponseDTO responseDTO = personaServiceImpl.eliminarPersona(id);
		return new ResponseEntity<>(responseDTO, responseDTO.getHttpStatus());
	}
	
	@PostMapping("/ingresarPersona")
	@CrossOrigin(origins = "*")
	public ResponseEntity<ResponseDTO> ingresarPersonas(@RequestBody PersonaDTO persona) {
		ResponseDTO responseDTO = personaServiceImpl.crearPersona(persona);
		return new ResponseEntity<>(responseDTO, responseDTO.getHttpStatus());
	}
	
	@PostMapping("/actualizarPersona")
	@CrossOrigin(origins = "*")
	public ResponseEntity<ResponseDTO> actualizarPersonas(@RequestBody PersonaDTO persona) {
		ResponseDTO responseDTO = personaServiceImpl.actualizarPersona(persona);
		return new ResponseEntity<>(responseDTO, responseDTO.getHttpStatus());
	}
	//comentario

}
