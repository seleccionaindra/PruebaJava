package api.rest.indra.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import api.rest.indra.models.Persona;
import api.rest.indra.models.service.IPersonaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("/api")
public class PersonaController {

	private static final Logger LOGGER = Logger.getLogger(PersonaController.class.getName());
	
	@Autowired
	IPersonaService personaService;

	@RequestMapping(value = "/persona", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Persona createPersona(@RequestBody Persona personaIn) {
		LOGGER.log(Level.INFO, "createPersona -> personaIn:".concat(personaIn.toString()));
		Persona personaOut = personaService.crearPersona(personaIn);
		LOGGER.log(Level.INFO, "personaOut:".concat(String.valueOf(personaOut)));
		return personaOut;
	}

	@RequestMapping(value = "/personas", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Persona> getPersonas() {
		List<Persona> listPersona = personaService.getPersonas();
		LOGGER.log(Level.INFO, "listPersona:".concat(String.valueOf(listPersona)));
		return listPersona;
	}

	@RequestMapping(value = "/persona/{cedula}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Persona getPersona(@PathVariable(value="cedula") Long cedula) {
		LOGGER.log(Level.INFO, "getPersona -> cedula:".concat(cedula.toString()));
		Persona personaOut = personaService.getPersona(cedula);
		LOGGER.log(Level.INFO, "personaOut:".concat(String.valueOf(personaOut)));
		return personaOut;
	}

	@RequestMapping(value = "/persona/{cedula}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Persona updatePersona(@PathVariable(value="cedula") Long cedula, @RequestBody Persona personaIn) {
		LOGGER.log(Level.INFO, "updatePersona -> cedula:".concat(cedula.toString()).concat(", personaIn:").concat(personaIn.toString()));
		Persona personaOut = personaService.updatePersona(cedula, personaIn);
		LOGGER.log(Level.INFO, "personaOut:".concat(String.valueOf(personaOut)));
		return personaOut;
	}

	@RequestMapping(value = "/persona/{cedula}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Persona deletePersona(@PathVariable(value="cedula") Long cedula) {
		LOGGER.log(Level.INFO, "deletePersona -> cedula:".concat(cedula.toString()));
		Persona personaOut = personaService.deletePersona(cedula);
		LOGGER.log(Level.INFO, "personaOut:".concat(String.valueOf(personaOut)));
		return personaOut;
	}

}
