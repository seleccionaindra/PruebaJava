package api.rest.indra.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.indra.model.entity.Personas;
import api.rest.indra.service.IPersonasService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600 )
@RestController
@RequestMapping(value = "/api/personas")
public class PersonasApi {
	@Autowired
	private IPersonasService iPersonasService;
	
	@GetMapping(path = "/buscarPersonasTodo")
	public List<Personas> buscarPersonasTodo(){
		return iPersonasService.buscarPersonasTodo();
	}
	
	@PostMapping
	public Personas guardarPersona(@RequestBody Personas personas){
		iPersonasService.guardarPersona(personas);
		return personas;
	}
	
	@PutMapping
	public Personas actualizarPersona(@RequestBody Personas personas){
		iPersonasService.actualizarPersona(personas);
		return personas;
	}
	
	@DeleteMapping(path = "/{cedula}")
	public String borrarPersona(@PathVariable(name="cedula") String cedula){
		iPersonasService.borrarPersona(cedula);
		return cedula;
	}
	
	@GetMapping(path = "/buscarPersonasTodo/{cedula}")
	public Personas buscarPersona(@PathVariable(name="cedula") String cedula){
		return iPersonasService.buscarPersona(cedula);
	}
}
