package api.rest.indra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.rest.indra.models.entity.Persona;
import api.rest.indra.models.services.IPersonaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonaRestContoller {

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/personas")
	public List<Persona> index() {
		return personaService.findAll();
	}
	
	@GetMapping("/personas/{id}")
	public Persona show(@PathVariable Long id) {
		return this.personaService.findById(id);
	}
	
	@PostMapping("/personas")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona create(@RequestBody Persona persona) {
		this.personaService.save(persona);
		return persona;
	}
	
	@PutMapping("/personas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona update(@RequestBody Persona persona, @PathVariable Long id) {
		Persona currentPersona = this.personaService.findById(id);
		currentPersona.setNombres(persona.getNombres());
		currentPersona.setApellidos(persona.getApellidos());
		currentPersona.setCedula(persona.getCedula());
		currentPersona.setGenero(persona.getGenero());
		currentPersona.setEdad(persona.getEdad());
		this.personaService.save(currentPersona);
		return currentPersona;
	}
	
	@DeleteMapping("/personas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Persona currentPersona = this.personaService.findById(id);
		this.personaService.delete(currentPersona);
	}
}
