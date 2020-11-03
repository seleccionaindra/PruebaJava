package api.rest.indra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.indra.model.Persona;
import api.rest.indra.service.IPersonaServ;

@RestController
public class PersonaRest {
	
	@Autowired
	private IPersonaServ serv;
	
	@PostMapping("/persona")
	public String crearPersona () {
		Persona p1 = new Persona("Felipe", "Galeano", "1020762066", "M", "26");
		return serv.crearPersona(p1);
	}

}
