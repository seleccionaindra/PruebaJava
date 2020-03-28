package api.rest.indra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.rest.indra.exception.PersonaNotFoundException;
import api.rest.indra.model.Persona;
import api.rest.indra.service.IPersonaService;

@RestController
public class PersonaResource {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/personas")
	public List<Persona> all() {
		return personaService.getPersonas();
	}
	
	@PostMapping("/personas")
	public Persona save(@RequestBody Persona newPersona) {
		return personaService.createPersona(newPersona);
	}
	
	@GetMapping("/personas/{id}")
	public Persona get(@PathVariable Long id) throws PersonaNotFoundException {
		return personaService.getPersona(id);
	}
	
	@PutMapping("/personas/{id}")
	public Persona update(@RequestBody Persona newPersona, @PathVariable Long id) throws PersonaNotFoundException {
		return personaService.updatePersona(newPersona, id);
	}
	
	@DeleteMapping("/personas/{id}")
	public void remove(@PathVariable Long id) throws PersonaNotFoundException {
		personaService.removePersona(id);
    }
}
